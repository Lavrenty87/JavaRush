package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int x = (int) (Math.random() * 100);
        return "date_bot_" + x;

    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage( "Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            String[] splitMess = message.split(": ");

            if (splitMess.length != 2) return;

                switch (splitMess[1]) {
                    case "дата" :
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                        BotClient.this.sendTextMessage("Информация для " + splitMess[0] + ": "  + simpleDateFormat.format(Calendar.getInstance().getTime()));
                        break;

                    case "день" :
                        SimpleDateFormat simpleDayFormat = new SimpleDateFormat("d");
                        BotClient.this.sendTextMessage("Информация для " + splitMess[0] + ": "  + simpleDayFormat.format(Calendar.getInstance().getTime()));
                        break;

                    case "месяц" :
                        SimpleDateFormat simpleMansFormat = new SimpleDateFormat("MMMM");
                        BotClient.this.sendTextMessage("Информация для " + splitMess[0] + ": "  + simpleMansFormat.format(Calendar.getInstance().getTime()));
                        break;

                    case "год" :
                        SimpleDateFormat simpleYarFormat = new SimpleDateFormat("YYYY");
                        BotClient.this.sendTextMessage("Информация для " + splitMess[0] + ": "  + simpleYarFormat.format(Calendar.getInstance().getTime()));
                        break;

                    case "время" :
                        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("H:mm:ss");
                        BotClient.this.sendTextMessage("Информация для " + splitMess[0] + ": "  + simpleTimeFormat.format(Calendar.getInstance().getTime()));
                        break;

                    case "час" :
                        SimpleDateFormat simpleOyrFormat = new SimpleDateFormat("H");
                        BotClient.this.sendTextMessage("Информация для " + splitMess[0] + ": "  + simpleOyrFormat.format(Calendar.getInstance().getTime()));
                        break;
                    case "минуты" :
                        SimpleDateFormat simpleMinesFormat = new SimpleDateFormat("m");
                        BotClient.this.sendTextMessage("Информация для " + splitMess[0] + ": "  + simpleMinesFormat.format(Calendar.getInstance().getTime()));
                        break;
                    case "секунды" :
                        SimpleDateFormat simpleSekFormat = new SimpleDateFormat("s");
                        BotClient.this.sendTextMessage("Информация для " + splitMess[0] + ": "  + simpleSekFormat.format(Calendar.getInstance().getTime()));
                        break;
                }

        }
    }
    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
