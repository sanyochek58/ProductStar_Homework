package org.example;

public class Main {

    public static String name = "Alex";
    public static int amount = 100;

    public static int deduct(String account, int value) throws AccessDeniedException, InsufficientAmountException{
        if(!name.equals(account)){
            throw new AccessDeniedException("Имя аккаунта не совпадает с владельцем счёта !");
        }

        if(amount < value){
            throw new InsufficientAmountException("Недостаточно средств");
        }
        amount = amount - value;
        return amount;
    }

    public static void main(String[] args) {
        try{
            deduct(name, 50);
            System.out.println("Остаток: " + amount);
        }catch (AccessDeniedException e){
            throw new AccessDeniedException(e.getMessage());
        }catch (InsufficientAmountException em){
            throw new InsufficientAmountException(em.getMessage());
        }
    }
}