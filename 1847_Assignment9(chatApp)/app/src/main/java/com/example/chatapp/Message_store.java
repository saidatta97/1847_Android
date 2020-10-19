package com.example.chatapp;

import java.util.ArrayList;

public class Message_store {

    final ArrayList<Message> chats = new ArrayList<>();

    private Message_store(){};

    static Message_store getInstance() {
        if(instance == null){
            instance = new Message_store();
        }
        return instance;
    }

    private static  Message_store instance;
}

