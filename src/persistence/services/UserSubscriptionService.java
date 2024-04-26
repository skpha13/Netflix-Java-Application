package persistence.services;

import model.Utilizator;
import persistence.SubscriptieRepository;
import persistence.UtilizatorRepository;

import java.util.Arrays;
import java.util.Scanner;

public class UserSubscriptionService {
    private final UtilizatorRepository utilizatorRepository;
    private final SubscriptieRepository subscriptieRepository;

    public UserSubscriptionService(UtilizatorRepository utilizatorRepository, SubscriptieRepository subscriptieRepository) {
        this.utilizatorRepository = utilizatorRepository;
        this.subscriptieRepository = subscriptieRepository;
    }

    public void connectUserToSubscription() {
        Scanner sc = new Scanner(System.in);

        System.out.println(Arrays.toString(utilizatorRepository.getAll().toArray()));
        System.out.println("Enter user ID: ");

        int userId = sc.nextInt();
        sc.nextLine();

        System.out.println(Arrays.toString(subscriptieRepository.getAll().toArray()));
        System.out.println("Enter subscription ID: ");

        int subscriptionId = sc.nextInt();
        sc.nextLine();

        Utilizator u = utilizatorRepository.get(userId);
        u.setSubscriptie_id(subscriptionId);

        utilizatorRepository.update(u);
    }
}
