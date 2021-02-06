package com.andersen.shop;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class InternetShop implements Shop, Serializable {
    private static InternetShop shop;
    private static Warehouse warehouse;
    private List<User> users;

    private InternetShop() {
    }

    public static synchronized InternetShop getInstance() {
        if (Objects.isNull(shop)) {
            warehouse = new Warehouse();
            return new InternetShop();
        }
        return shop;
    }

    @Override
    public void showAllProducts() {
        warehouse.getProductQuantity().keySet().forEach(Product::showInfo);
    }

    @Override
    public void showProductsInBucket(int userId) {
        users.get(userId).getBucket().showProducts();
    }

    @Override
    public void addProductToBucketById(int id, int userId) {
        if (id >= 0 && id < warehouse.getProductQuantity().keySet().size()) {
            System.out.println(users);
            System.out.println(users.get(userId).getBucket());
            users.get(userId).getBucket().addProduct(warehouse.getProductQuantity().keySet().stream().filter(x -> x.getId() == id).findAny().orElseThrow());
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void removeFromBucketById(int id, int userId) {
        users.get(userId).getBucket().removeById(id);
    }

    @Override
    public void clear(int userId) {
        users.get(userId).getBucket().clear();
    }

    public int addUser(User user) {
        if (Objects.isNull(users)) {
            users = new ArrayList<>();
        }
        users.add(user);
        user.setId(users.size() - 1);
        return (users.size() - 1);
    }
}
