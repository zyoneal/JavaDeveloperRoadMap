
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalDemo {

    private static final Account DEFAULT_ACCOUNT = new Account("Default", "Account", "vp@gmail.com", 9999.0);

    public static void main(String[] args) {

        Account account = new Account("Viktor", "helloPassword", "vp@ukr.net", 1000.0);

        // of.() - throw new exception if object is null
        Optional<Account> optionalAccount = Optional.of(account);
        // ofNullable() - allows put null
        Optional<Account> optionalNullableAccount = Optional.ofNullable(account);
        // empty() - if you need to create empty optional
        Optional<Account> optionalEmptyAccount = Optional.empty();

        // ===========================Основные функции================================
        // 1. Если значение есть - выполнять какую-то функцию, если нет - ничего не делать
        // 2. Если значение есть - выполнять какую-то функцию, если нет - выполнять что-то другое
        // 3. Если значение есть - вернуть его, если значения нет - вернуть какое-то дефолтное значение
        // 4. Если значение есть - вернуть его, если значения нет - кинуть какую-то ошибку


    }

    // Is not correct to process value in the old imperative way
    private static void printAccountUsingWrongApproach(Optional<Account> optionalAccount) {
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            System.out.println(account);
        }
    }

    // The right way is to pass a consumer
    private static void printAccountUsingRightApproach(Optional<Account> optionalAccount) {
        optionalAccount.ifPresent(System.out::println);
    }

    // orElse() - Вернуть дефолтное значение которое не потребует ресурсов (Выполнения логики)
    private static void printAccountOrDefault(Optional<Account> optionalAccount) {
        Account account = optionalAccount.orElse(DEFAULT_ACCOUNT);
        System.out.println(account);
    }

    // orElseGet() - если создание обьекта потребует ресурсов (Выполнения логики)
    private static void printAccountOrRandomLazily(Optional<Account> optionalAccount) {
        Account account = optionalAccount.orElseGet(() -> Account.getAccount());
        System.out.println(account);
    }

    // Old variant
    private static void printAccount(Account account) {
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("No such element exists!");
        }
    }

    // New variant
    private static void getOptionalAccount(Optional<Account> optionalAccount) {
        optionalAccount.ifPresentOrElse(System.out::println,
                () -> System.out.println("No such element exists!"));
    }

    // Declarative - good
    private static Account getAccountByEmail(List<Account> accounts, String email) {
        return findAccountByEmail(accounts, email)
                .orElseThrow(NoSuchElementException::new);
    }

    // Imperative - wrong way
    private static Account getAccountByEmailImperatively(List<Account> accounts, String email) {
        Optional<Account> optionalAccount = findAccountByEmail(accounts, email);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        } else throw new NoSuchElementException();
    }

    // Declarative - good
    private static void printAccountWithMaxBalanceDeclaratively(List<Account> accounts) {
        accounts.stream()
                .max(Comparator.comparing(Account::getBalance))
                .ifPresentOrElse(System.out::println, () -> System.out.println("No accounts found!"));
    }

    // Imperative - wrong way
    private static void printAccountWitMaxBalanceImperatively(List<Account> accounts) {
        if (accounts.size() > 0) {
            Account accountWithMaxBalance = accounts.get(0);
            for (Account account : accounts) {
                if (account.getBalance().compareTo(accountWithMaxBalance.getBalance()) > 0) {
                    accountWithMaxBalance = account;
                }
            }
            System.out.println(accountWithMaxBalance);
        } else System.out.println("No such found!");
    }

    //==============================
    private static Optional<Account> findAccountByEmail(List<Account> accounts, String email) {
        return accounts.stream()
                .filter(a -> a.getEmail().equals(email))
                .findAny();
    }

}
