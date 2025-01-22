import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ChallengeStepByStep {

    // Adım 1: 100 adet random sayı oluşturma
    public static List<Integer> createRandomList() {
        Random random = new Random();
        List<Integer> list = random.ints(100, 0, 1000)  // 0-1000 arası 100 sayı
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Adım 1 - Random liste oluşturuldu: " + list);
        return list;
    }

    // Adım 2: Listenin kopyasını oluşturma
    public static List<Integer> createListCopy(List<Integer> originalList) {
        List<Integer> copyList = new ArrayList<>(originalList);
        System.out.println("Adım 2 - Liste kopyalandı: " + copyList);
        return copyList;
    }

    // Adım 3: 0-100 arası random sayı üretme
    public static int generateRandomIndex() {
        Random random = new Random();
        int randomIndex = random.nextInt(100);
        System.out.println("Adım 3 - Random index oluşturuldu: " + randomIndex);
        return randomIndex;
    }

    // Adım 4: Kopya listeden eleman silme
    public static int removeElementFromCopyList(List<Integer> copyList, int index) {
        int removedNumber = copyList.remove(index);
        System.out.println("Adım 4 - Kopya listeden " + removedNumber + " sayısı silindi");
        System.out.println("Güncel kopya liste: " + copyList);
        return removedNumber;
    }

    // Adım 5: Eksik elemanı bulma (3 farklı yöntem)

    // Yöntem 1: Toplam farkı ile bulma
    public static int findMissingBySum(List<Integer> originalList, List<Integer> copyList) {
        int originalSum = originalList.stream().mapToInt(Integer::intValue).sum();
        int copySum = copyList.stream().mapToInt(Integer::intValue).sum();
        int missingNumber = originalSum - copySum;
        System.out.println("Adım 5.1 - Toplam yöntemi ile bulunan eksik sayı: " + missingNumber);
        return missingNumber;
    }

    // Yöntem 2: Stream ile karşılaştırarak bulma
    public static int findMissingByComparison(List<Integer> originalList, List<Integer> copyList) {
        int missingNumber = originalList.stream()
                .filter(num -> !copyList.contains(num))
                .findFirst()
                .orElse(-1);
        System.out.println("Adım 5.2 - Karşılaştırma yöntemi ile bulunan eksik sayı: " + missingNumber);
        return missingNumber;
    }

    // Yöntem 3: HashSet ile bulma
    public static int findMissingBySet(List<Integer> originalList, List<Integer> copyList) {
        var originalSet = new java.util.HashSet<>(originalList);
        copyList.forEach(originalSet::remove);
        int missingNumber = originalSet.iterator().next();
        System.out.println("Adım 5.3 - HashSet yöntemi ile bulunan eksik sayı: " + missingNumber);
        return missingNumber;
    }
}
