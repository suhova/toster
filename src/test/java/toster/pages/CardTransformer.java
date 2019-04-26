package toster.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardTransformer {
    private CardTransformer(){};

    public static List<CardWrapper> wrap(List<WebElement> elements){
        if (elements.isEmpty()) {
            return Collections.emptyList();
        }
        List<CardWrapper> friends = new ArrayList<>();
        for (WebElement friend: elements) {
            friends.add(new CardWrapper(friend));
        }
        return friends;
    }
}
