package main;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreManagement {
    //array of the different stores created
    ArrayList<Store> stores = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<String> admins = new ArrayList<>();//contains all the IDs of the those who are admins
    ArrayList<String> managers = new ArrayList<>();//contains all the IDs of the those who are managers
    ArrayList<String> staff = new ArrayList<>();//contains all the IDs of the those who are staff



    //can create a store
    public void storeCreation(String ID) {
        Scanner input = new Scanner(System.in);
        String role = validateID(ID);
        if(role.equals("Admin")){
            Store store = new Store();
            System.out.println("what will be the store name?");
            store.storeName = input.nextLine();
            System.out.println("what will be the store location?");
            store.location = input.nextLine();
            System.out.println("what is the contact information?");
            store.contactInfo = input.nextLine();
            System.out.println("what is the store type?");
            store.storeType = input.nextLine();
            System.out.println("what is the opening date? Example: 09/13/2023");
            store.opening = input.nextLine();
            //adds the store that was created to the array of stores
            stores.add(store);
        }
        if(!role.equals("Admin")){
            System.out.println("You don't have permission to complete this action");
        }


    }

    //updates store features
    public void updateStore(String ID){
        Scanner input = new Scanner(System.in);
        String status = validateID(ID);
        if(status != null) {
            if(status.equals("Admin")) {
                System.out.println("What would you like to update?");
                System.out.println("1: store name");
                System.out.println("2: location");
                System.out.println("3: contact information");
                System.out.println("4: store type opening date");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1 -> {
                        System.out.println("What is the name of the store you want to change?");
                        String name = input.nextLine();
                        for (Store store : stores) {
                            if (name.equals(store.storeName)) {
                                System.out.println("What is the name you want to change it to?");
                                store.storeName = input.nextLine();
                                //for my purposes
                                System.out.println("changed feature: " + store.storeName);
                                break;
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("What is the location of the store you want to change?");
                        String location = input.nextLine();
                        for (Store store : stores) {
                            if (location.equals(store.location)) {
                                System.out.println("What is the location you want to change it to?");
                                store.location = input.nextLine();
                                //for my own purposes
                                System.out.println("changed feature: " + store.location);
                                break;
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("What is the contact information of the store you want to change?");
                        String info = input.nextLine();
                        for (Store store : stores) {
                            if (info.equals(store.contactInfo)) {
                                System.out.println("What is the contact information you want to change it to?");
                                store.contactInfo = input.nextLine();
                                //for my own purposes
                                System.out.println("chnaged feature: " + store.contactInfo);
                                break;
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("What is the opening date of the store you want to change?");
                        String date = input.nextLine();
                        for (Store store : stores) {
                            if (date.equals(store.opening)) {
                                System.out.println("What is the date you want to change it to?");
                                store.opening = input.nextLine();
                                //for my own purposes
                                System.out.println("chnaged feature: " + store.opening);
                                break;
                            }
                        }
                    }
                }


            }


        }else {
            System.out.println("The ID you provided was not valid");
        }

    }
    //assigns role and ID to the correct user role array
    public Boolean assignID(String ID) {
        boolean created = false;
        String status = validateID(ID);
        if(status != null) {
            System.out.println("Your ID is not unique. Please try again.");
        }
        if(status == null) {
            Scanner input = new Scanner(System.in);
            System.out.println("what role will this ID have?");
            String role = input.nextLine();
            switch (role) {
                case "Admin", "admin" -> {
                    created = true;
                    admins.add(ID);
                }
                case "Manager", "manager" -> {
                    created = true;
                    managers.add(ID);
                }
                case "Staff", "staff" -> {
                    created = true;
                    staff.add(ID);
                }
                default -> System.out.println("Your input is invalid");
            }
        }
        return created;
    }
    //validates ID to make sure it's not a duplicate
    public String validateID(String ID) {
        String status=null;
        for (String admin : admins) {
            if (ID.equals(admin)) {
                status = "Admin";
                break;
            }
        }
        for (String manager : managers) {
            if (ID.equals(manager)) {
                status = "Manager";
                break;
            }
        }
        for (String s : staff) {
            if (ID.equals(s)) {
                status = "Staff";
                break;
            }
        }
        return status;
    }


    //search by name
    public int searchStoreName(String name) {
        int index =100;
        for(int i =0;i< stores.size();i++) {
            if(name.equals(stores.get(i).storeName)) {
                System.out.println("Here is the store information");
                System.out.println("Store Location: "+stores.get(i).location);
                System.out.println("Store Type: "+stores.get(i).storeType);
                System.out.println("Store Information: "+stores.get(i).contactInfo);
                System.out.println("Store Opening Date: "+stores.get(i).opening);
                index = i;
                //since each store has a different name
                break;
            }
        }
        return index;
    }

    //create items and adds it to the store they indicate
    public void itemCreation(String ID) {
        //String name, String description, String category, Double price, int quantity
        //checks if the person requesting to create the item is authorized
        String role = validateID(ID);
        if(role != null) {
            if(role.equals("Admin")) {
                Scanner input = new Scanner(System.in);
                System.out.println("What would you like to order?");
                String name = input.nextLine();
                Item newItem = new Item();
                newItem.itemName = name;
                System.out.println("Description?");
                newItem.description = input.nextLine();
                System.out.println("Category?");
                newItem.category = input.nextLine();
                System.out.println("Price?");
                newItem.price  = input.nextDouble();
                System.out.println("Quantity");
                newItem.initialQuantity = input.nextInt();
                //adds newly created item to item array
                items.add(newItem);
                System.out.println("it was added");


            }
        }
        else {
            System.out.println("The ID you provided was not valid");
        }

    }
    public int searchItemName(String name) {
        int index=0;
        for(int i =0; i< items.size(); i++) {
            if(name.equals(items.get(i).itemName)) {
                System.out.println("Description: "+ items.get(i).description);
                System.out.println("Category: "+ items.get(i).category);
                System.out.println("Price: "+ items.get(i).price);
                index=i;
                //since each item should be named uniquely
                break;
            }
        }
        return index;
    }

    public void addItemToStore(String ID) {
        String role = validateID(ID);

        if(role != null) {
            Scanner input = new Scanner(System.in);
            System.out.println("what is the item you want to add?");
            String item = input.nextLine();
            //find the item in the item array
            int itemIndex=searchItemName(item);
            //create new item
            new Item();
            Item newItem;
            //copy item into newly created item instance
            newItem=items.get(itemIndex);
            System.out.println("what is the quantity you want to add?");
            int quantity = input.nextInt();
            input.nextLine();
            //the limit per item is 20
            if(newItem.initialQuantity + quantity > 20) {
                System.out.println("You can not have over 20 of the same item. Please try again");
            }
            else {
                //you will subtract the amount you are adding to the store from the original quantity
                items.get(itemIndex).initialQuantity -= quantity;
                //assign the number of that item that the store will have
                newItem.quantity = quantity;
                System.out.println("what store do you want to add to");
                String store = input.nextLine();
                //get index of the store you want to add an item to
                int storeIndex=searchStoreName(store);
                //add the item to that store
                stores.get(storeIndex).addItems(newItem);
                //for my own purposes
                //stores.get(storeIndex).print();
            }
        }else {
            System.out.println("The ID you provided was not valid");
        }
    }


    public static void main(String[] args) {
        StoreManagement l2 = new StoreManagement();
        Scanner input = new Scanner(System.in);
        System.out.println("You will need to first create an ID and assign a role");
        System.out.println("Please provide your ID ");
        String newID = input.nextLine();
        Boolean status = l2.assignID(newID);
        for(int i = 0; i<3;i++) {
            if(status) {
                System.out.println("what would you like to do? ");
                System.out.println("1: Create a store");
                System.out.println("2: assign a role");
                System.out.println("3: Create an item");
                System.out.println("4: Add an item to a store");
                System.out.println("5: Update a store");
                int choice = input.nextInt();
                input.nextLine();
                System.out.println("Please provide your ID ");
                String ID = input.nextLine();
                //input.nextLine();
                System.out.println("passed through here ");
                if(choice == 1){
                    //ID = input.nextLine();
                    l2.storeCreation(ID);
                    //l2.deleteStore(ID);

                }
                if(choice == 2) {
                    //ID = input.nextLine();
                    l2.assignID(ID);

                }if(choice == 3) {
                    //ID = input.nextLine();
                    l2.itemCreation(ID);
                }
                if(choice == 4) {
                    //ID = input.nextLine();
                    l2.addItemToStore(ID);
                    //for my own purposes
                    System.out.println("store added? "+l2.stores.get(0).storeName);
                    System.out.println("item to first store added? "+l2.stores.get(0).storeItems.get(0).itemName);
                }if(choice == 5) {
                    //ID = input.nextLine();
                    l2.updateStore(ID);
                }


            }else {
                System.out.println("Please try to assign an ID again");
                newID = input.nextLine();
                status=l2.assignID(newID);
            }

        }


    }
    public static class Store{
        String storeName;
        String location;
        String contactInfo;
        String storeType;
        String opening;
        ArrayList<Item> storeItems = new ArrayList<>(); //Store items

        public void addItems(Item items) {
            //limit of items for each store times 20
            if(storeItems.size() == 20) {
                System.out.println("the store has reached capacity. More items can not be added");
            }else {
                this.storeItems.add(items);
            }
        }

    }
    public static class Item{
        String itemName;
        String description;
        String category;
        Double price;
        int initialQuantity;
        //quantity this will be the amount of that item a store has
        int quantity;
        //should I add limit for amount of initial quantity?


    }


}
