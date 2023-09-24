public class TodoList {

    public static String[] model = new String[10];

    public static  java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewGetTodoList();
    }

    /**
     * Show all list items
     */
    public static void getTodoList() {
        System.out.println("TodoList");
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var number = i + 1;

            if (todo != null) {
                System.out.println(number + ". " + todo);
            }
        }
    }

    public static void testGetTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar OOP di Java";
        model[2] = "Belajar Golang Dasar";
        model[3] = "Belajar Redis";
        model[4] = "Belajar Elastic Search";
        model[5] = "Belajar Apache Kafka";
        model[6] = "Belajar RabbitMQ";
        getTodoList();
    }

    /**
     * Add a new item to the list
     */
    public static void addTodoList(String todo) {
        // is Array full?
        var isFUll = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFUll = false;
                break;
            }
        }

        // if it is indeed full resize array to 2x
        if (isFUll) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25 ; i++) {
            addTodoList("Example todo " + i);
        }
        getTodoList();
    }

    /**
     * Remove an item from the list
     */
    public static boolean removeTodoList(Integer number) {
        if (number - 1 >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length ; i++) {
                if (i == (model.length -1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }

        } return true;
    }

    public static void testRemoveTodoList() {
        var result = removeTodoList(32);
        System.out.println(result);

        testGetTodoList();
    }

    /**
     *  Input Data
     */

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
     return data;
    }

    /**
     *
     * @Test input
     */

    public static void testInput() {
        var name = input("Name");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * view for getTodoList
     */
    public static void viewGetTodoList() {
        while (true) {
            getTodoList();

            System.out.println("Menu : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    /**
     * test view getTodoList
     */

    public static void testViewGetTodoList() {
    addTodoList("One");
    addTodoList("Two");
    addTodoList("Three");

    viewGetTodoList();
    }

    /**
     * view for addTodoList
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {
            // batal
        } else addTodoList(todo);
    }

    /**
     * test view addTodoList
     */

    public static void testViewAddTodoList() {
        viewAddTodoList();

        getTodoList();
    }

    /**
     * view for removeTodoList
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");

        var number = input("Nomor yang dihapus (x Jika Batal)");

        if (number.equals("x")) {
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus Todo List");
            }
        }
    }

    /**
     * test view remove todoList
     */

    public static void testViewRemoveTodoList() {
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");

        getTodoList();

        viewRemoveTodoList();

        getTodoList();
    }
}
