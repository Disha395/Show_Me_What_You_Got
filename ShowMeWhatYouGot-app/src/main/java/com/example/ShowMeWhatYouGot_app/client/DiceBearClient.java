package com.example.ShowMeWhatYouGot_app.client;
import org.springframework.stereotype.Component;

@Component
public class DiceBearClient {

    public String getAvatar(String str) {
        return "https://api.dicebear.com/6.x/avataaars/svg?seed=%s".formatted(str);
    }
}