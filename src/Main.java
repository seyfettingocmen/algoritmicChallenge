import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Challenge başlıyor...\n");

        // Adım 1: Random liste oluştur
        List<Integer> originalList = ChallengeStepByStep.createRandomList();

        // Adım 2: Liste kopyala
        List<Integer> copyList = ChallengeStepByStep.createListCopy(originalList);

        // Adım 3: Random index üret
        int randomIndex = ChallengeStepByStep.generateRandomIndex();

        // Adım 4: Kopya listeden eleman sil
        int removedNumber = ChallengeStepByStep.removeElementFromCopyList(copyList, randomIndex);

        System.out.println("\nDoğrulama aşaması:");
        System.out.println("Gerçekte silinen sayı: " + removedNumber);

        // Adım 5: Üç farklı yöntemle eksik sayıyı bul
        ChallengeStepByStep.findMissingBySum(originalList, copyList);
        ChallengeStepByStep.findMissingByComparison(originalList, copyList);
        ChallengeStepByStep.findMissingBySet(originalList, copyList);
    }
}
