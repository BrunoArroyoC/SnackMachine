package maquina_snacks;

interface messegesExceptions {

    default void showNoSnack(){
        System.out.println("Error, there is not any snack.");
    }

    default void saveSnack(){
        System.out.println("Load Snack successfully");
    }
    default void notFoundSnack(){
        System.out.println("Sorry, we can not found the snack");
    }
    default void menu(){
        System.out.println("""
                1. Buy Snack
                2. Show Ticket
                3. Add Snack
                4. Exit
                """);
    }

}
