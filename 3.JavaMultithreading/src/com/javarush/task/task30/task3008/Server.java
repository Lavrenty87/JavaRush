package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Чат сервер запущен");
            while (true) {
                // Ожидаем входящее соединение и запускаем отдельный поток при его принятии
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервера.");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());
            String userName = null;
            try {
                Connection connection = new Connection(socket);
                //Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
                //Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED).
                userName = serverHandshake(connection);
                //Сообщать новому участнику о существующих участниках.
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                //Запускать главный цикл обработки сообщений сервером.
                serverMainLoop(connection, userName);

                if (!userName.equals(null)) {
                    connectionMap.remove(userName);
                    Message message = new Message(MessageType.USER_REMOVED, userName);
                    sendBroadcastMessage(message);
                }
                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто.");

            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом " + socket.getRemoteSocketAddress());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом " + socket.getRemoteSocketAddress());
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String newUserName;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message m = connection.receive();
                if (m.getType().equals(MessageType.USER_NAME)) {
                    newUserName = m.getData();
                    if ((!newUserName.equals("")) && (!connectionMap.containsKey(newUserName))) {
                        connectionMap.put(newUserName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return newUserName;
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> m : connectionMap.entrySet()) {
                String key = m.getKey();
                if (!key.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, key));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String data = message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + data));
                } else {
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() +
                            ". Тип сообщения не соответствует протоколу.");
                }
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> map : connectionMap.entrySet()) {
            Connection connectionValue = map.getValue();
            try {
                connectionValue.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение " + connectionValue.getRemoteSocketAddress());
                e.printStackTrace();
            }
        }
    }
}
