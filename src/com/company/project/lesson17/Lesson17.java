package com.company.project.lesson17;

import java.util.*;

public class Lesson17 {
    public static void main(String[] args) {
        // интерфейс Map<KeyType, ValueType>
        // предоставляет набор методов для работы с ассоциациями: ключ - значение
        // одному ключу всегда соответствует только одно значение
        // ключи не могут дублироваться
        // порядок хранения ключей и связанных с ними значений зависит от конкретных реализаций
        // есть возможность получения: set ключей, collection значений, set пар (ключ+значение)

        // Реализации:
        // 1. HashMap<KeyType, ValueType>
        // неупорядоченная по ключам ассоциация
        // позволяет использовать null в качестве ключа
        // реализована на основе hash таблицы

        // 2. LinkedHashMap<KeyType, ValueType>
        // упорядоченная по ключам ассоциация
        // позволяет использовать null в качестве ключа
        // реализована на основе hash таблицы

        // 3. EnumMap<KeyTypeEnum, ValueType>
        // использует только элементы перечислений в качестве ключей
        // хранит только массив значений
        // при создании экземпляра необходимо передавать ссылку на класс перечисления

        // 4. TreeMap<KeyType, ValueType>
        // хранит пары в отсортированном по ключам виде
        // для KeyType должен быть определен натуральный порядок сортировки или
        // в конструктор TreeMap необходимо передать экземпляр Comparator

        // 5. WeakHashMap<KeyType, ValueType>
        // неупорядоченная по ключам ассоциация
        // реализована на основе hash таблицы
        // очищается сборщиком, когда на ключи не остаётся сильных ссылок

        // ключи типа String
        // значения типа Integer
        HashMap<String, Integer> customers = new HashMap<>();
        customers.put("Москва", 790);
        customers.put("Ростов", 250);
        customers.put("Новгород", 20);
        // произойдет перезапись значения по ключу "Ростов"
        customers.put("Ростов", 300);
        customers.put("Самара", 630);
        customers.put(null, 1000);
        customers.put("СПб", null);

        System.out.println(customers.size()); // 5
        System.out.println(customers.isEmpty()); // false

        // удаление пары по ключу
        customers.remove(null); // 1000
        customers.remove(null); // null
        customers.remove("СПб"); // null
        // удалит, если в мапе существует пара "Ростов" : 300
        customers.remove("Ростов", 300); // true
        customers.remove("Самара", 200); // false

        // замена значения по ключу
        // метод вернет старое значение
        customers.replace("Самара", 1200); // 630
        // заменит значение, если в мапе существует пара "Москва" : 790
        customers.replace("Москва", 790, 840);

        // получение значения по ключу (не удаление)
        System.out.println(customers.get("Москва")); // 840
        System.out.println(customers.get("СПБ")); // null

        System.out.println(customers.getOrDefault("Москва", -1));
        System.out.println(customers.getOrDefault("СПБ", -1));
        Integer spbValue = customers.getOrDefault("СПБ", -1);
        if (spbValue == -1) {
            System.out.println("Нет удалось получить информацию по СПб");
        } else {
            System.out.println(spbValue); // может быть null
        }

        if (customers.containsKey("Ростов")) {
            System.out.println("Информация о Ростове уже содержится");
        }

        if (customers.containsValue(1000)) {
            System.out.println("Значение 1000 содержится в мапе");
        }

        // коллекция значений
        Collection<Integer> customersValues = customers.values();
        // множество ключей
        Set<String> customersKeys = customers.keySet();
        // множество пар (ключ + значение)
        Set<Map.Entry<String, Integer>> customersPairs = customers.entrySet();

        for (Map.Entry<String, Integer> customersPair : customersPairs) {
            System.out.println(customersPair.getKey());
            System.out.println(customersPair.getValue());

            if (customersPair.getValue() > 1000) {
                System.out.println("В городе " + customersPair.getKey() +
                        "количество покупателей больше 1000");
            }
        }

        ArrayList<String> cities = getCities(customers, 500);
        System.out.println(cities);

        // ключ типа ClientAuthData.Role
        // значения типа List<ClientAuthData>
        EnumMap<ClientAuthData.Role, List<ClientAuthData>> clientsByRole =
                new EnumMap<>(ClientAuthData.Role.class);

        // [USER, ADMIN, MODERATOR]
        clientsByRole.put(ClientAuthData.Role.USER, new ArrayList<>());
        clientsByRole.put(ClientAuthData.Role.ADMIN, new ArrayList<>());
        // List<ClientAuthData>[] values = new List<ClientAuthData>[3]
        // values[ClientAuthData.Role.USER.ordinal()] = new ArrayList<>();
        ClientAuthData data01 = new ClientAuthData("qqq", "123", ClientAuthData.Role.USER);
        clientsByRole.get(ClientAuthData.Role.USER).add(data01);
        // values[ClientAuthData.Role.USER.ordinal()]

        System.out.println(clientsByRole.size()); // 2

        ClientAuthData clientData = new ClientAuthData("222", "222", ClientAuthData.Role.MODERATOR);
        add(clientsByRole, clientData);
        System.out.println(clientsByRole);


        EnumSet<ClientAuthData.Role> rolesFull = EnumSet.allOf(ClientAuthData.Role.class);
        EnumSet<ClientAuthData.Role> rolesEmpty = EnumSet.noneOf(ClientAuthData.Role.class);
        rolesEmpty.add(ClientAuthData.Role.ADMIN);
        rolesEmpty.add(ClientAuthData.Role.MODERATOR);
        EnumSet<ClientAuthData.Role> rolesEx = EnumSet.complementOf(EnumSet.of(ClientAuthData.Role.USER));
        EnumSet<ClientAuthData.Role> fromTo = EnumSet.range(ClientAuthData.Role.USER, ClientAuthData.Role.values()[2]);

        TreeMap<String, List<String>> students = new TreeMap<>();
        students.put("AGroup", new ArrayList<>(Arrays.asList("Петрова", "Иванов")));
        students.put("KGroup", new ArrayList<>(Arrays.asList("Попова", "Романова")));
        students.put("TGroup", new ArrayList<>(Arrays.asList("Гурова", "Ртищев")));
        students.put("EGroup", new ArrayList<>(Arrays.asList("Бокарев", "Потапова")));




    }

    // написать static метод,
    // который принимает на вход HashMap<String, Integer> map и int max,
    // и возвращает список городов, где количество покупателей меньше max
    private static ArrayList<String> getCities(HashMap<String, Integer> map, int max) {
        ArrayList<String> cities = new ArrayList<>();
        for (Map.Entry<String, Integer> keyValuePair : map.entrySet()) {
            if (keyValuePair.getValue() < max) {
                cities.add(keyValuePair.getKey());
            }
        }
        return cities;
    }

    // написать static метод, который принимает на вход
    // EnumMap<ClientAuthData.Role, List<ClientAuthData>> map и
    // ClientAuthData clientData
    // и добавляет clientData в список в зависимости от роли
    public static void add(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map,
                           ClientAuthData authData) {
        ClientAuthData.Role key = authData.getRole();
        if (map.get(key) == null) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(authData);
    }

    // написать static метод, который принимает на вход
    // EnumMap<ClientAuthData.Role, List<ClientAuthData>> map
    // и возвращает Map<String, String> c парами userName - password
    // в результирующий Map должны попасть userName и password
    // пользователей (ClientAuthData.Role.USER)
    private static Map<String, String> getUsersLoginPasswords(EnumMap<ClientAuthData.Role, List<ClientAuthData>> map){
        List<ClientAuthData> clientAuthData = map.get(ClientAuthData.Role.USER);
        if (clientAuthData == null) return null;
        Map<String, String> loginPassword = new HashMap<>();
        for (ClientAuthData data : clientAuthData) {
            loginPassword.put(data.getUserName(), data.getPassword());
        }
        return loginPassword;
    }
}
