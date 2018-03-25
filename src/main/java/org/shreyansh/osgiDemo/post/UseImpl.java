package org.shreyansh.osgiDemo.post;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.scripting.sightly.pojo.Use;

import javax.script.Bindings;
import java.util.HashMap;
import java.util.Map;

public class UseImpl implements Use {

    String coffee;
    int quantity;
    int cost;

    @Override
    public void init(Bindings bindings) {

        System.out.println("In init");

        SlingHttpServletRequest request = (SlingHttpServletRequest) bindings.get("request");

        Map<String, Integer> prices = new HashMap();
        prices.put("Espresso", 10);
        prices.put("Latte", 20);
        prices.put("Frappe", 30);

        coffee = request.getParameter("coffee");
        quantity = Integer.valueOf(request.getParameter("quantity"));
        cost = prices.get(coffee) * quantity;

        System.out.println("Coffee " + coffee);
        System.out.println("Quantiy " + quantity);
        System.out.println("Cost " + cost);
    }

    public String getCoffee() {
        return coffee;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCost() {
        return cost;
    }
}
