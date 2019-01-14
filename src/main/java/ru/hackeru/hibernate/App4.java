package ru.hackeru.hibernate;

import java.util.*;

public class App4 {

    public static void main(String[] args) {
        DAO<Worker> workerDao = new WorkerDao();
        DAO<Department> departmetDao = new DepartmentDao();
        DAO<Address> addressDao = new AddressDao();
        addressDao.add(new Address("Moscow", "Arbat", 5, 1));
        addressDao.add(new Address("Moscow", "Novoslobodskaya", 21, 28));
        addressDao.add(new Address("Moscow", "Gorky", 1, 8));
        addressDao.add(new Address("St. Petersburg", "Malaya Sadovaya", 11, 9));
        addressDao.add(new Address("St. Petersburg", "Gorokhovaya", 10, 4));
        addressDao.add(new Address("St. Petersburg", "Bolshaya Sadovaya", 18, 1));
        addressDao.add(new Address("New York", "Broadway", 14, 15));
        addressDao.add(new Address("New York", "Grand Street", 3, 39));
        addressDao.add(new Address("New York", "5th Avenue", 8, 5));
        addressDao.add(new Address("Tokyo", "Mita Dori", 7, 3));
        addressDao.add(new Address("Tokyo", "Kappabashi-dori", 44, 5));
        addressDao.add(new Address("Tokyo", "Takeshita Street", 5, 22));
        addressDao.add(new Address("New Delhi", "Shahjahan Road", 3, 4));
        addressDao.add(new Address("New Delhi", "Vasant Kunj Marg", 8, 9));
        addressDao.add(new Address("New Delhi", "Nelson Mandela Road", 1, 19));
        /***************************/
        departmetDao.add(new Department("Finance", null));
        departmetDao.add(new Department("Human Resources", null));
        departmetDao.add(new Department("IT", null));
        departmetDao.add(new Department("Logistics", null));
        departmetDao.add(new Department("Marketing", null));
        /***************************/
        workerDao.add(new Worker("Pasya Pupkin", 100000, 53, addressDao.getById(1), departmetDao.getById(1)));
        workerDao.add(new Worker("Basya Bupkin", 100000, 53, addressDao.getById(2), departmetDao.getById(2)));
        workerDao.add(new Worker("Dasya Dupkin", 100000, 53, addressDao.getById(3), departmetDao.getById(3)));
        workerDao.add(new Worker("Gasya Gupkin", 100000, 53, addressDao.getById(5), departmetDao.getById(4)));
        workerDao.add(new Worker("Rasya Rupkin", 100000, 53, addressDao.getById(6), departmetDao.getById(5)));
        workerDao.add(new Worker("Ivan Sidorov", 75000, 27, addressDao.getById(4), departmetDao.getById(1)));
        workerDao.add(new Worker("John Doe", 73000, 27, addressDao.getById(7), departmetDao.getById(2)));
        workerDao.add(new Worker("Dohn Joe", 78000, 33, addressDao.getById(8), departmetDao.getById(3)));
        workerDao.add(new Worker("Steve Moe", 79000, 41, addressDao.getById(9), departmetDao.getById(4)));
        workerDao.add(new Worker("Joe Shmoe", 81000, 50, addressDao.getById(10), departmetDao.getById(5)));
        workerDao.add(new Worker("Robert Paulson", 60000, 25, addressDao.getById(11), departmetDao.getById(1)));
        workerDao.add(new Worker("Dale Nixon", 59000, 28, addressDao.getById(12), departmetDao.getById(1)));
        workerDao.add(new Worker("Omar Ravenhurst", 66000, 27, addressDao.getById(13), departmetDao.getById(3)));
        workerDao.add(new Worker("Ned Ludd", 49000, 31, addressDao.getById(14), departmetDao.getById(3)));
        workerDao.add(new Worker("Geoffrey Cohen", 83000, 44, addressDao.getById(15), departmetDao.getById(4)));
        workerDao.add(new Worker("Pasyilisa Pupkina", 90000, 53, addressDao.getById(1), departmetDao.getById(1)));
        workerDao.add(new Worker("Basyilisa Bupkina", 90000, 53, addressDao.getById(2), departmetDao.getById(2)));
        workerDao.add(new Worker("Dasyilisa Dupkina", 90000, 53, addressDao.getById(3), departmetDao.getById(3)));
        workerDao.add(new Worker("Gasyilisa Gupkina", 90000, 53, addressDao.getById(5), departmetDao.getById(4)));
        workerDao.add(new Worker("Rasyilisa Rupkina", 90000, 53, addressDao.getById(6), departmetDao.getById(5)));
        workerDao.add(new Worker("Katya Sidorova", 75000, 27, addressDao.getById(4), departmetDao.getById(1)));
        workerDao.add(new Worker("Jane Doe", 73000, 27, addressDao.getById(7), departmetDao.getById(2)));
        workerDao.add(new Worker("Dane Joe", 78000, 33, addressDao.getById(8), departmetDao.getById(3)));
        workerDao.add(new Worker("Monika Moe", 79000, 41, addressDao.getById(9), departmetDao.getById(4)));
        workerDao.add(new Worker("Jane Shmoe", 81000, 50, addressDao.getById(10), departmetDao.getById(5)));
        workerDao.add(new Worker("Rebecca Paulson", 60000, 25, addressDao.getById(11), departmetDao.getById(1)));
        workerDao.add(new Worker("Diana Nixon", 59000, 28, addressDao.getById(12), departmetDao.getById(1)));
        workerDao.add(new Worker("Ustritsa Ravenhurst", 66000, 27, addressDao.getById(13), departmetDao.getById(3)));
        workerDao.add(new Worker("Nora Ludd", 49000, 31, addressDao.getById(14), departmetDao.getById(3)));
        workerDao.add(new Worker("Stephanie Cohen", 83000, 44, addressDao.getById(15), departmetDao.getById(4)));
        /***************************/
        Department dep1 = departmetDao.getById(1);
        dep1.setBoss(workerDao.getById(1));
        Department dep2 = departmetDao.getById(2);
        dep2.setBoss(workerDao.getById(2));
        Department dep3 = departmetDao.getById(3);
        dep3.setBoss(workerDao.getById(3));
        Department dep4 = departmetDao.getById(4);
        dep4.setBoss(workerDao.getById(4));
        Department dep5 = departmetDao.getById(5);
        dep5.setBoss(workerDao.getById(5));
        departmetDao.update(dep1);
        departmetDao.update(dep2);
        departmetDao.update(dep3);
        departmetDao.update(dep4);
        departmetDao.update(dep5);
        /******************************************/
        ArrayList<Department> departments = new ArrayList<>(departmetDao.getAll());
        ArrayList<Address> addresses = new ArrayList<>(addressDao.getAll());
        ArrayList<Worker> workers = new ArrayList<>(workerDao.getAll());

        //1) Avg. salary in all depts.
        System.out.println("***********************************");
        for (Department dep : departments) {
            double mean = 0;
            int count = 0;
            for (Worker worker : workers) {
                if (worker.getWork().getName().equals(dep.getName())) {
                    mean += worker.getSalary();
                    count++;
                }
            }
            if (count!=0) mean/=count;
            System.out.println("Dept.: " + dep.getName() + " Avg. salary: " + mean);
        }

        //2) Group workers by cities, if only 1 worker in city - don't print
        System.out.println("***********************************");
        Set<String> cities = new HashSet<>();
        for (Address address : addresses) {
            String city = address.getCity();
            if (cities.contains(city)) continue;
            cities.add(city);
            ArrayList<Worker> zemeli = new ArrayList<>();
            for (Worker worker : workers) {
                if (worker.getHome().getCity().equals(city)) zemeli.add(worker);
            }
            if (zemeli.size() >= 1) for (Worker zemelya : zemeli) System.out.println(zemelya);
        }

        //3) Find dept. with the youngest workers (avg. age)
        System.out.println("***********************************");
        String minName = null;
        double min = Double.MAX_VALUE;
        for (Department dep : departments) {
            double avgAge = 0;
            int count = 0;
            for (Worker worker : workers) {
                if (worker.getWork().getName().equals(dep.getName())) {
                    avgAge += worker.getAge();
                    count++;
                }
            }
            if (count != 0) avgAge/=count;
            if (avgAge != 0 && avgAge < min) {minName = dep.getName(); min = avgAge;}
        }
        if (min != Double.MAX_VALUE) System.out.println("Youngest dept.: " + minName + ", avg. age: " + min);
        else System.out.println("Error: 0 non-empty departments.");
    }
}
