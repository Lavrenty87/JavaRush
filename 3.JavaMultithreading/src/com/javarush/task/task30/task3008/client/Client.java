package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected;

    public static void main(String[] args) {
        Client c = new Client();
        c.run();
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера.");
        return ConsoleHelper.readString();
    }
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера.");
        return ConsoleHelper.readInt();
    }
    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите Ваше имя.");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole() {
        return true;
    }
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }
    protected void sendTextMessage(String text) {

        try {
            Message message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Соединение с сервером потеряно");
            clientConnected = false;
            e.printStackTrace();
        }
    }

    public void run () {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
            wait();
            } catch (InterruptedException e) {
            e.printStackTrace();
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }
            if (clientConnected) ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'");
            else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            while (clientConnected) {
                String s = ConsoleHelper.readString();

                if (s.equals("exit")) break;
                else {
                    if (shouldSendTextFromConsole()) {
                        sendTextMessage(s);
                    }
                }
            }
        }
    }

    public class SocketThread extends Thread {
        //- должен выводить текст message в консоль
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        //- должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату.
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " - присоединился к чату.");
        }

        //- должен выводить в консоль, что участник с именем userName покинул чат.
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " - покинул чат.");
        }

        //а) Устанавливать значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
        //б) Оповещать (пробуждать ожидающий) основной поток класса Client.
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.NAME_REQUEST) {
                    String userN = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userN));

                } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        //Этот метод будет реализовывать главный цикл обработки сообщений сервера
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        @Override
        public void run() {

            try {
                Socket socket = new Socket(getServerAddress(), getServerPort());
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
                e.printStackTrace();
            }
        }
    }
}
