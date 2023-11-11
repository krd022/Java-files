package main;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Store {
    Items[] Gushers= new Items[10];
    int rasCount=0; //tracks the number of Gushers in the store
    Items[] Dove= new Items[5];
    int soapCount=0;//tracks the amount of Dove in the store
    Items[] Lemonade= new Items[7];
    int juiceCount=0;//tracks the amount of Lemonade in the store

    public void createProduct(String product, String name) {
        //String product, String name, LocalDate date, int time
        Scanner input = new Scanner(System.in);
        if(name.isEmpty() || product.isEmpty()) {
            System.out.println("ProductID and ProductName are required to create a product.");
        }else {
            System.out.println("Would you like to provide the date and time for markdown?");
            String answer =input.nextLine();
            if(answer.equals("no")) {
                defaultCreateProduct(product,name);
            }else {
                System.out.println("What is the expiration date? Please provide in this format: DD-MMM-YYYY. Example: 30 Oct 2023");
                String date=input.nextLine();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMM uuuu");
                LocalDate dateUpdated=LocalDate.parse(date, dateTimeFormatter);
                System.out.println("What is the time duration for the markdown date");
                int time=input.nextInt();
                input.nextLine();

                if(name.equals("Gushers")) {
                    //checks if Gushers have reached their max
                    if(rasCount == 10) {
                        System.out.println("We are unable to create another Gusher because the product has reached its maximum");
                    }else{
                        //checks if the product name is unique by comparing it to every product ID in the Gusher category
                        String status;
                        status=validateID(product);
                        if( status != null) {
                            System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
                        }
                        if(status == null) {
                            //if productName is unique, the instance for that object is created and is saved in the store
                            Items fruit = new Items();
                            fruit.ProductName= name;
                            fruit.ProductID = product;
                            fruit.ExpiryDate = dateUpdated;
                            fruit.MarkdownDate = fruit.ExpiryDate.minusDays(time);
                            Gushers[rasCount]=fruit;
                            rasCount++;
                            System.out.println("ProductName with the ProductID created successfully");

                        }
                    }
                }
                if(name.equals("Dove")) {
                    //checks if Dove has reached their max
                    if(soapCount == 5) {
                        System.out.println("We are unable to create another Dove because the product has reached its maximum");
                    }else {
                        //checks if the product name is unique by comparing it to every product ID in the Dove category
                        String status;
                        status=validateID(product);
                        if( status != null) {
                            System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
                        }
                        if(status == null) {
                            Items soap = new Items();
                            soap.ProductName= name;
                            soap.ProductID = product;
                            soap.ExpiryDate = dateUpdated;
                            soap.MarkdownDate = soap.ExpiryDate.minusDays(time);
                            Dove[soapCount]=soap;
                            soapCount++;
                            System.out.println("ProductName with the ProductID created successfully");
                        }
                    }
                }
                if(name.equals("Lemonade")) {
                    //checks if Lemonade has reached their max
                    if(juiceCount == 7) {
                        System.out.println("We are unable to create another Lemonade because the product has reached its maximum");
                    }else{
                        //checks if the product name is unique by comparing it to every product ID in the Dove category
                        String status;
                        status=validateID(product);
                        if( status != null) {
                            System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
                        }
                        if(status == null) {
                            //if productName is unique, the instance for that object is created and is saved in the store
                            Items juice = new Items();
                            juice.ProductName= name;
                            juice.ProductID = product;
                            juice.ExpiryDate = dateUpdated;
                            juice.MarkdownDate = juice.ExpiryDate.minusDays(time);
                            Lemonade[juiceCount]=juice;
                            juiceCount++;
                            System.out.println("ProductName with the ProductID created successfully");

                        }
                    }
                }
            }
        }
    }

    public void defaultCreateProduct(String product, String name) {
        //checks if item is a Gusher
        if(name.equals("Gushers") || name.equals("Gusher") ) {
            //checks if Gushers have reached their max
            if(rasCount == 10) {
                System.out.println("We are unable to create another Gusher because the product has reached its maximum");
            }else{
                //checks if the product name is unique
                String status;
                status=validateID(product);
                if( status != null) {
                    System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
                }
                if(status == null) {
                    //if productName is unique, the instance for that object is created and is saved in the store
                    Items fruit = new Items();
                    fruit.ProductName= name;
                    fruit.ProductID = product;
                    Gushers[rasCount]=fruit;
                    fruit.setExpiration(); //it is given the default value
                    fruit.setMarkdown();//it is given the default value
                    Gushers[rasCount] = fruit;
                    rasCount++;
                    System.out.println("ProductName with the ProductID created successfully");
                }
            }
        }
        if(name.equals("Dove")) {
            //checks if item is a Gusher
            if(soapCount == 5) {
                System.out.println("We are unable to create another Dove because the product has reached its maximum");
            }else {
                //checks if the product name is unique
                String status;
                status=validateID(product);
                if( status != null) {
                    System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
                }
                if(status == null) {
                    //if productName is unique, the instance for that object is created and is saved in the store
                    Items soap = new Items();
                    soap.ProductName= name;
                    soap.ProductID = product;
                    soap.setExpiration(); //it is given the default value
                    soap.setMarkdown(); //it is given the default value
                    Dove[soapCount]=soap;
                    soapCount++;
                    System.out.println("ProductName with the ProductID created successfully");
                }
            }
        }

        if(name.equals("Lemonade")) {
            if(juiceCount == 7) {
                System.out.println("We are unable to create another Lemonade because the product has reached its maximum");
            }else{
                //checks if the product name is unique
                String status;
                status=validateID(product);
                if( status != null) {
                    System.out.println("ProductName should have a uniqueID, the ProductName already exists with the same uniqueID");
                }
                if(status == null) {
                    //if productName is unique, the instance for that object is created and is saved in the store
                    Items juice = new Items();
                    juice.ProductName= name;
                    juice.ProductID = product;
                    juice.setExpiration(); //it is given the default value
                    juice.setMarkdown(); //it is given the default value
                    Lemonade[juiceCount]=juice;
                    juiceCount++;
                    System.out.println("ProductName with the ProductID created successfully");

                }
            }
        }


    }
    public void displayProduct(String name, String ID){
        Boolean status;
        //checks if the product exists, if not message will get printed
        String created =validateID(ID);
        if(!name.equals(created)) {
            System.out.println("Product name/ProductID not found");
        }
        //if the product exists, its attributes will get printed
        if( created != null) {
            if(name.equals("Gushers") || name.equals("Gusher")) {
                //prints out the products attributes if name and ID match
                status=printProduct(ID, Gushers, rasCount);
                //if we have the ID, but it belongs to a different item name, this will print
                if(!status) {
                    System.out.println("The product name you provided does not match");
                }
            }
            if(name.equals("Dove")) {
                //prints out the products attributes if name and ID match
                status=printProduct(ID, Dove, soapCount);
                //if we have the ID, but it belongs to a different item name, this will print
                if(!status) {
                    System.out.println("The product name you provided does not match");
                }
            }
            if(name.equals("Lemonade")) {
                //prints out the products attributes if name and ID match
                status=printProduct(ID, Lemonade, juiceCount);
                //if we have the ID, but it belongs to a different item name, this will print
                if(!status) {
                    System.out.println("The product name you provided does not match");
                }
            }
        }

    }

    //prints out the attributes of the product passed in
    public Boolean printProduct(String ID, Items[] array, int count) {
        boolean status=false;

        for(int i =0; i< count;i++) {
            if(array[i].ProductID.equals(ID)) {
                //once the product ID is found in the array, it will print it the name, ID, expiry date and markdown date
                System.out.println("Product name: "+array[i].ProductName);
                System.out.println("Product ID: "+array[i].ProductID);
                System.out.println("Expiry date: "+array[i].ExpiryDate);
                System.out.println("Markdown date: "+array[i].MarkdownDate);
                status=true;
                break;
            }
        }
        return status;
    }

    //if no parameters are given
    public void emptyDisplayProduct(){
        //if it's a Gusher, prints out the name and product ID
        for(int i =0; i< rasCount; i++) {
            System.out.println("Product name: Gushers");
            System.out.println("Product ID: "+Gushers[i].ProductID);
        }
        //if it's a Dove, prints out the name and product ID
        for(int i =0; i< soapCount; i++) {
            System.out.println("Product name: Dove");
            System.out.println("Product ID: "+Dove[i].ProductID);
        }
        //if it's a Lemonade, prints out the name and product ID
        for(int i =0; i< juiceCount; i++) {
            System.out.println("Product name: Lemonade");
            System.out.println("Product ID: "+Lemonade[i].ProductID);
        }

    }

    //checks if the product ID provided is in the system
    public String validateID(String ID) {
        String name=null;

        for(int i= 0;i< rasCount;i++) {
            if (ID.equals(Gushers[i].ProductID)) {
                name = "Gushers";

                break;
            }
        }
        for(int i= 0;i< soapCount;i++) {
            if (ID.equals(Dove[i].ProductID)) {
                name = "Dove";
                break;
            }
        }
        for(int i= 0;i< juiceCount;i++) {
            if (ID.equals(Lemonade[i].ProductID)) {
                name = "Lemonade";
                break;
            }
        }
        //return the name of the product
        return name;
    }






    public void displayProductToRefill(String product){
        //checks if product exists in the system
        String name=validateID(product);
        if( name == null) {
            System.out.println("Product name/ProductID not found");
        }
        //if we do have the product ID, the code below will run
        if(name != null) {
            if(name.equals("Gushers")) {
                //min for Gushers is 5
                //if one Gusher needs to be replenished
                if(5 - rasCount == 1) {
                    System.out.println(5-rasCount+" Gusher need to be replenished");
                }
                //if many Gushers need to be replenished
                else if(5 - rasCount > 1){
                    System.out.println(5-rasCount+" Gushers need to be replenished");
                }
                //if no Gushers need to be replenished
                else {
                    System.out.println("No Gushers need to be replenished");
                }
            }
            if(name.equals("Dove")) {
                //min for Dove is 2
                if(soapCount < 2) {
                    //if many Dove's needs to be replenished
                    System.out.println(2-soapCount+" Dove need to be replenished");
                }
                //if no Dove's need to be replenished
                else {
                    System.out.println("No Dove need to be replenished");
                }
            }
            if(name.equals("Lemonade")) {
                //min for Lemonade is 6
                if(juiceCount < 6) {
                    //if many Lemonades need to be replenished
                    System.out.println(6-juiceCount+" Lemonade need to be replenished");
                }
                //if no Lemonade need to be replenished
                else{
                    System.out.println("No Lemonade need to be replenished");
                }

            }

        }
    }
    //if no parameters are given
    public void displayProductToRefill(){
        //if one Gusher needs to be replenished
        if(5 - rasCount == 1) {
            System.out.println(5-rasCount+" Gusher need to be replenished");
        }
        //if many Gushers need to be replenished
        else if(5 - rasCount > 1){
            System.out.println(5-rasCount+" Gushers need to be replenished");
        }
        //if no Gushers need to be replenished
        else {
            System.out.println("No Gushers need to be replenished");
        }
        //if many Dove's needs to be replenished
        if(soapCount < 2) {
            System.out.println(2-soapCount+" Dove need to be replenished");
        }
        //if no Dove's need to be replenished
        else {
            System.out.println("No Dove need to be replenished");
        }
        //if many Lemonades need to be replenished
        if(juiceCount < 6) {
            System.out.println(6-juiceCount+" Lemonade need to be replenished");
        }
        //if no Lemonade need to be replenished
        else{
            System.out.println("No Lemonade need to be replenished");
        }

    }
    public void displayProductCount(String ID) {
        String name=validateID(ID);
        if( name == null) {
            System.out.println("Product name/ProductID not found");
        }
        if(name != null) {
            if(name.equals("Gushers")) {
                System.out.println("The number of Gushers: "+rasCount);
            }
            if(name.equals("Dove")) {
                System.out.println("The number of Dove: "+soapCount);
            }
            if(name.equals("Lemonade")) {
                System.out.println("The number of Lemonade: "+juiceCount);
            }
        }
    }
    public void displayProductCount() {
        System.out.println("The number of each product:");
        System.out.println("Gushers: "+rasCount);
        System.out.println("Dove: "+soapCount);
        System.out.println("Lemonade: "+juiceCount);

    }
    public void displayProductsExpiryDate(String ID){
        String name=validateID(ID);
        if( name == null) {
            System.out.println("Product name/ProductID not found");
        }
        if(name != null) {
            //checks if ID belongs to Gushers
            if(name.equals("Gushers") || name.equals("Gusher")) {
                printExpiry(ID, Gushers,rasCount);
            }

            //checks if ID belongs to Dove
            if(name.equals("Dove")) {
                printExpiry(ID, Dove,soapCount);
            }
            //checks if ID belongs to Lemonade
            if(name.equals("Lemonade")) {
                printExpiry(ID, Lemonade,juiceCount);
            }
        }
    }
    //prints out the expiration date of the item
    public void printExpiry(String ID, Items[] array, int count) {
        for(int i= 0;i< count;i++) {
            if(ID.equals(array[i].ProductID)) {
                System.out.println("The Expiry date of "+ID+" is "+array[i].ExpiryDate);
                break;
            }
        }

    }
    public void displayProductsExpiryDate(){
        //prints expiration date of Gushers' items
        for(int i= 0;i< rasCount;i++) {
            System.out.println("The Expiry date of "+Gushers[i].ProductID+" is "+Gushers[i].ExpiryDate);
        }
        //prints expiration date of Dove items
        for(int i= 0;i< soapCount;i++) {
            System.out.println("The Expiry date of "+Dove[i].ProductID+" is "+Dove[i].ExpiryDate);
        }
        //prints expiration date of Lemonade items
        for(int i= 0;i< juiceCount;i++) {
            System.out.println("The Expiry date of "+Lemonade[i].ProductID+" is "+Lemonade[i].ExpiryDate);
        }


    }
    public void displayExpiredProducts(){
        Boolean status;
        //if there are no products
        if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
            System.out.println("Sorry we don't have any products");
        }else {
            //checks if any Gushers are expired
            printExpired(Gushers, rasCount);

            //checks if any Dove are expired
            printExpired(Dove, soapCount);

            //checks if any Lemonade is expired
            status=printExpired(Lemonade,juiceCount);

            if(!status) {
                System.out.println("No products are expired");
            }

        }
    }
    //prints any items that are expired, if anything gets printed returns value true
    public Boolean printExpired(Items[] array, int count) {
        boolean status=false;
        for(int i= 0;i< count;i++) {
            if(array[i].ExpiryDate.equals(LocalDate.now()) || array[i].ExpiryDate.isBefore(LocalDate.now())) {
                System.out.println("THIS PRODUCT IS EXPIRED");
                System.out.println("Product Name: "+ array[i].ProductName);
                System.out.println("Product ID: "+ array[i].ProductID);
                System.out.println("EXPIRATION DATE: "+ array[i].ExpiryDate);
                status=true;
            }
        }
        return status;
    }

    public void displayProductsInMarkDown(){
        Boolean status;
        //if there are no products
        if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
            System.out.println("Sorry we don't have any products");
        }else {
            //checks if Gushers are past their markdown date
            printInMarkdown(Gushers, rasCount);

            //checks if Dove is past their markdown date
            printInMarkdown(Dove, soapCount);

            //checks if Lemonade is past their markdown date
            status=printInMarkdown(Lemonade, juiceCount);
            if(!status) {
                System.out.println("No products are past their markdown date");
            }

        }
    }
    //prints items that are past their markdown date if any are printed true are returned
    public Boolean printInMarkdown(Items[] array, int count) {
        boolean status=false;
        for(int i= 0;i< count;i++) {
            if(array[i].MarkdownDate.isBefore(LocalDate.now())) {
                System.out.println("This product is past its markdown date");
                System.out.println("Product Name: "+ array[i].ProductName);
                System.out.println("Product ID: "+ array[i].ProductID);
                System.out.println("Markdown date: "+ array[i].MarkdownDate);
                status = true;
            }
        }
        return status;
    }
    public void displayProductsForMarkDown(){
        Boolean status;
        //if there are no products
        if(rasCount ==0 && soapCount==0 && juiceCount==0 ) {
            System.out.println("Sorry we don't have any products");
        }else {
            //checks if Gushers have any due in a week
            printForMarkdown(Gushers, rasCount);

            //checks if Dove have any due in a week
            printForMarkdown(Dove, soapCount);

            //checks if Lemonade have any due in a week
            status=printForMarkdown(Lemonade, juiceCount);

            if(!status) {
                System.out.println("No products markdown date is in a week");
            }

        }

    }
    //prints out items whose markdown date is in a week, if any are printed true is returned
    public Boolean printForMarkdown(Items[] array, int count) {
        boolean status=false;
        for(int i= 0;i< count;i++) {
            if(array[i].MarkdownDate.isEqual(LocalDate.now().plusDays(7))) {
                System.out.println("This product's markdown date is in a week");
                System.out.println("Product Name: "+ array[i].ProductName);
                System.out.println("Product ID: "+ array[i].ProductID);
                System.out.println("Markdown date: "+ array[i].MarkdownDate);
                status = true;
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Store store = new Store();
        boolean on = true;
        while(on) {
            System.out.println("How may we help you?");
            System.out.println("1: Create a product");
            System.out.println("2: Display a product");
            System.out.println("3: Display products that need to be refilled");
            System.out.println("4: Display product count");
            System.out.println("5: Display product expiration date");
            System.out.println("6: Display all expired products");
            System.out.println("7: Display products past the markdown date");
            System.out.println("8: Display products whose markdown date is in a week");
            System.out.println("9: Log out");
            int choice = input.nextInt();
            String name;
            String product;
            input.nextLine();
            if(choice == 1) {
                System.out.println("What product would you like to initialize: Gushers, Dove or Lemonade");
                name=input.nextLine();
                System.out.println("What is the product ID? Example: 25871");
                product=input.nextLine();
                store.createProduct(product,name);
                continue;
            }	if(choice == 6) {
                store.displayExpiredProducts();
                continue;
            }
            if(choice == 7) {
                store.displayProductsInMarkDown();
                continue;
            }
            if(choice == 8) {
                store.displayProductsForMarkDown();
                continue;
            }
            if(choice == 9 ) {
                System.out.println("Goodbye!");
                on = false;
                continue;
            }
            if(store.rasCount ==0 && store.soapCount==0 && store.juiceCount==0 ) {
                System.out.println("Sorry not available");
            }else {
                if(choice == 2) {
                    System.out.println("Would you like to provide the name and ID of the product");
                    String answer = input.nextLine();
                    if(answer.equals("no")){
                        store.emptyDisplayProduct();
                    }else {
                        System.out.println("What is the name of the product?");
                        name = input.nextLine();
                        System.out.println("What is the ID of the product?");
                        String ID = input.nextLine();
                        store.displayProduct(name,ID);
                    }
                }if(choice == 3) {
                    System.out.println("Would you like to provide the product ID?");
                    String answer = input.nextLine();
                    if(answer.equals("no")) {
                        store.displayProductToRefill();
                    }else {
                        System.out.println("What is the the ID of the product?");
                        product = input.nextLine();
                        store.displayProductToRefill(product);
                    }
                }if(choice == 4) {
                    System.out.println("Would you like to provide a product ID?");
                    String answer = input.nextLine();
                    if(answer.equals("no")) {
                        store.displayProductCount();
                    }else {
                        System.out.println("What is the the ID of the product?");
                        product = input.nextLine();
                        store.displayProductCount(product);
                    }
                }
                if(choice == 5) {
                    System.out.println("Would you like to provide the product ID?");
                    String answer = input.nextLine();
                    if(answer.equals("no")) {
                        store.displayProductsExpiryDate();
                    }else {
                        System.out.println("What is the the ID of the product?");
                        product = input.nextLine();
                        store.displayProductsExpiryDate(product);
                    }
                }
            }
        }


    }
    public static class Items{
        String ProductID;
        String ProductName;
        LocalDate ExpiryDate;
        LocalDate MarkdownDate;

        public void setExpiration(){
            ExpiryDate= LocalDate.now().plusMonths(3);//default value is 3 months
        }
        public void setMarkdown() {
            MarkdownDate= ExpiryDate.minusDays(6);// default value is 6 days
        }
    }

}
