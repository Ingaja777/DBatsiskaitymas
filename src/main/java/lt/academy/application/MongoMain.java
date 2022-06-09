package lt.academy.application;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import lt.academy.client.MongoClientProvider;
import lt.academy.data.BankAccount;
import lt.academy.data.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class MongoMain {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClientProvider.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("bankPayments");
        MongoCollection<User> users = database.getCollection("users", User.class);

        Scanner sc = new Scanner(System.in);

        users.insertMany(List.of(new User("111", "Petras123", "123", "Petras", "Petraitis"),
                new User("222", "Jonas123", "123", "Jonas", "Jonaitis"),
                new User("333", "Ona123", "123", "Ona", "Onaitienė")));


        MongoCollection<BankAccount> bankAccounts = database.getCollection("bankAccounts", BankAccount.class);

        bankAccounts.insertMany(List.of(new BankAccount("LT090908083745638", "SEB", "111", new BigDecimal(10000)),
                new BankAccount("LT045768947356", "LUMINOR", "222", new BigDecimal(5000)),
                new BankAccount("LT080308086789", "SWED BANK", "333", new BigDecimal(3000))));

//Verslo logika - trumpai - turėtų būti prisijungimas - kaip ir visose programose tikriname login ir password:
        System.out.println("Įveskite user ID");
        String currentUser = sc.nextLine();

        FindIterable<User> user = users.find(Filters.eq("userId", currentUser));
//Išlistiname susijusias vartotojo banko sąskaitas
        FindIterable<BankAccount> availableBankAccounts = bankAccounts.find(Filters.eq("userId", currentUser));

//Pasirenka banko sąskaitą
        String chosenBankAccount = sc.nextLine();
        FindIterable<BankAccount> currBankAccount = bankAccounts.find(Filters.eq("BankAccountNumber", chosenBankAccount));

//Pasirenka įvedamą sumą, tikriname ar ji ne didesnė už sąskaitos likutį, jeigu didesnė - pranešame,
//        jeigu ne - paimame likutį iš jo atimame sumą ir ir gautu skaičiumi atnaujiname duomenis, kartu atnaujiname ir gavėjo banko sąskaitą
        BigDecimal amount = new BigDecimal(sc.nextLine());

        bankAccounts.updateOne(Filters.eq("bankAccountNumber",chosenBankAccount), Updates.set());


    }
}

