package commands;

public interface help {
    static void help() {
        System.out.println("help : вывести справку по доступным командам.");
        System.out.println("info : вывести информацию о коллекции.");
        System.out.println("show : вывести все элементы коллекции.");
        System.out.println("add {element} : добавить новый элемент в коллекцию.");
        System.out.println("update id {element} : обновить значение id элемента коллекции.");
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id.");
        System.out.println("clear : очистить коллекцию.");
        System.out.println("save : сохранить коллекцию в файл.");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла.");
        System.out.println("exit : завершить программу (без сохранения в файл).");
        System.out.println("add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции.");
        System.out.println("add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции.");
        System.out.println("remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный.");
        System.out.println("average_of_number_of_wheels : вывести среднее значение поля numberOfWheels для всех элементов коллекции.");
        System.out.println("min_by_engine_power : вывести любой объект из коллекции, значение поля enginePower которого является минимальным.");
        System.out.println("filter_greater_than_type type : вывести элементы, значение поля type которых больше заданного.");
    }
}
