package com.design.pattern;

public class DecoratorPattern {
    interface Notifier {
        void sendNotification(String message);
    }

    class EmailNotifier implements Notifier {
        @Override
        public void sendNotification(String message) {
            System.out.println("Sending email: " + message);
        }
    }

    abstract class NotifierDecorator implements Notifier {
        protected Notifier notifier;

        public NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        @Override
        public void sendNotification(String message) {
            notifier.sendNotification(message);
        }
    }

    class SMSDecorator extends NotifierDecorator {
        public SMSDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void sendNotification(String message) {
            super.sendNotification(message);
            System.out.println("Sending SMS: " + message);
        }
    }

    class PushNotificationDecorator extends NotifierDecorator {
        public PushNotificationDecorator(Notifier notifier) {
            super(notifier);
        }

        @Override
        public void sendNotification(String message) {
            super.sendNotification(message);
            System.out.println("Sending push notification: " + message);
        }
    }

}
