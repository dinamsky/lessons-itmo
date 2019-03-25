package hospital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Hospital {

    private static int patientCount = 3;
    private List<Doctor> doctorList = new ArrayList<>();
    private List<Patient> patientsList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    String enterLogin;

    User currentUser;

    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);

    Administrator administrator;

    MainDoctor mainDoctor = new MainDoctor("Гааз Ф.П", "gaaz");
    Doctor doctor1 = new Doctor(0, "Павлов И.П.", "pavlov", "Neurochirurg");
    Doctor doctor2 = new Doctor(1, "Пирогов Н.И.", "pirogov", "Traumatolog");
    Doctor doctor3 = new Doctor(2, "Склифософский Н.В.", "sklif", "Dentist");

    Patient patient1 = new Patient("Путин В.В.", "patient1");
    Patient patient2 = new Patient("Медведев Д.А.", "patient2");
    Patient patient3 = new Patient("Сечин И.", "patient3");



    public void init() throws ParseException {

        doctorList.add(doctor1);
        doctorList.add(doctor2);
        doctorList.add(doctor3);

        patientsList.add(patient1);
        patientsList.add(patient2);
        patientsList.add(patient3);

        doctor1.addDoctorTimePatientMap( new Date(sdfDate.parse("2019-04-05 10:00").getTime()),patient1);

        doctor2.addDoctorTimePatientMap( new Date(sdfDate.parse("2019-04-05 11:00").getTime()),patient2);
        doctor2.addDoctorTimePatientMap( new Date(sdfDate.parse("2019-04-05 12:00").getTime()),patient3);

        doctor3.addDoctorTimePatientMap( new Date(sdfDate.parse("2019-04-05 12:00").getTime()),patient1);
        doctor3.addDoctorTimePatientMap( new Date(sdfDate.parse("2019-04-05 13:00").getTime()),patient2);
        doctor3.addDoctorTimePatientMap( new Date(sdfDate.parse("2019-04-05 14:00").getTime()),patient3);

    }


    public void open() throws ParseException {
        init();


        while (true) {
            currentUser = checkLogin();
            if (currentUser instanceof MainDoctor) {
                System.out.println();
                System.out.println("Нажмите клавишу:");
                System.out.println("1. Посмотреть всех пациентов");
                System.out.println("2. Посмотреть все записи к конкретному врачу");
                int choice = scanner.nextInt();
                switch (choice) {

                    case 1:
                        for (int i = 0; i < patientsList.size(); i++) {
                            System.out.println(i+". " + patientsList.get(i).getName());
                        }
                        break;

                    case 2:
                        System.out.println("Список врачей");
                        for (int i = 0; i < doctorList.size(); i++) {
                            System.out.println(i+". "+ doctorList.get(i).getName() + ". Специализация: " + doctorList.get(i).getSpecialisation());
                        }
                        System.out.println();
                        System.out.println("Укажите ID врача, записи к которому Вы хотите посмотреть?");
                        int choice2 = scanner.nextInt();

                        System.out.println(doctorList.get(choice2).getTimeForPatients());

                        System.out.println();
                        System.out.println("Выход");
                        System.out.println();
                        break;
                }


            } else if (currentUser instanceof Doctor) {
                System.out.println();
                System.out.println("Нажмите кнопку:");
                System.out.println("1. Посмотреть записи пациентов");
                System.out.println("2. Выйти из системы");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println(((Doctor) currentUser).getTimeForPatients());
                        break;
                    case 2:
                        break;
                }
                System.out.println();
                System.out.println("Выход из системы.");
                System.out.println();
                break;

            } else if (currentUser instanceof Patient) {
                System.out.println();
                System.out.println("Нажмите кнопку:");
                System.out.println("1. Записаться к врачу");
                System.out.println("2. Выйти из системы");

                int choise = scanner.nextInt();

                switch (choise) {
                    case 1:
                        System.out.println("Список врачей");
                        for (int i = 0; i < doctorList.size(); i++) {
                            System.out.println(i + ". " + doctorList.get(i).getName() + ". Специализация: " + doctorList.get(i).getSpecialisation());
                        }
                        System.out.println("----------------------------");
                        System.out.println("К какому врачу Вы хотите записаться?");
                        int choise2 = scanner.nextInt();
                        for (int i = 0; i < doctorList.size(); i++) {
                            if (choise2 == doctorList.get(i).getId()) {
                                System.out.println("Запись на этот год");

                                int month;
                                do {
                                    System.out.println("Пожалуйста введите номер месяца!");
                                    while (!scanner.hasNextInt()) {
                                        System.out.println("Это не число!");
                                        scanner.next(); // this is important!
                                    }
                                    month = scanner.nextInt();
                                } while (month <= 12 & month >=1);
                                System.out.println("Спасибо " + month);

                                int day;
                                do {
                                    System.out.println("Пожалуйста введите число месяца!");
                                    while (!scanner.hasNextInt()) {
                                        System.out.println("Это не число!");
                                        scanner.next(); // this is important!
                                    }
                                    day = scanner.nextInt();
                                } while (day <= 30 & day >=1);
                                System.out.println("Спасибо " + day);

                                System.out.println("Интервал приема пациентов  час, рабочее время  08:00 - 20:00");
                                System.out.println("В какое время вы хотите попасть на прием");
                                int hour;
                                do {
                                    System.out.println("Пожалуйста введите час!");
                                    while (!scanner.hasNextInt()) {
                                        System.out.println("Это не число!");
                                        scanner.next(); // this is important!
                                    }
                                    hour = scanner.nextInt();
                                } while (hour <= 23 & hour >=0);
                                System.out.println("Спасибо " + hour);


                                Calendar calendar = new GregorianCalendar(2019, month , day, hour, 00);
                                Date date = calendar.getTime();
                                System.out.println(date);

                                if (!doctorList.get(i).getDoctorTimePatientMap().containsKey(date)) {
                                    doctorList.get(i).addDoctorTimePatientMap(date, (Patient) currentUser);
//
                                    System.out.println("Вы успешно записались к врачу!");
                                }
                                else System.out.println("Запись на это время уже существует.");



                            }
                        }

                        break;
                    case 2:
                        break;
                }
                System.out.println();
                System.out.println("Выход из системы.");
                System.out.println();



            } else {
                System.out.println();
                System.out.println("Работа программы завершена");
                System.out.println();
                return;
            }

        }

    }


    public User checkLogin() {

        System.out.println("Введите логин или exit для выхода");
        enterLogin = scanner.next();

        if (enterLogin.equalsIgnoreCase("exit"))
            return null;

        else if (enterLogin.equalsIgnoreCase(mainDoctor.getLogin())) {
            System.out.println("Выполнен вход в систему. Ваше имя - " + mainDoctor.getName());
            System.out.println("Ваша роль в системе: Главный врач");
            return mainDoctor;
        } else {
            //проверка на доктора
            for (int i = 0; i < doctorList.size(); i++) {
                if (enterLogin.equals(doctorList.get(i).getLogin())) {
                    System.out.println("Выполнен вход в систему. Ваше имя - " + doctorList.get(i).getName());
                    System.out.println("Ваша роль в системе: Врач");
                    return doctorList.get(i);
                }
            }
            //проверка на пациента
            for (int i = 0; i < patientsList.size(); i++) {
                if (enterLogin.equals(patientsList.get(i).getLogin())) {
                    System.out.println("Вы вошли как пациент. Ваше имя: " + patientsList.get(i).getName());
                    return patientsList.get(i);
                }
            }
            //если не нашли пациента
            System.out.println("Вы не найдены в системе. Введите Ваше имя или exit для выхода");
            String name = scanner.next();
            if (!name.equalsIgnoreCase("exit")) {
                patientCount++;
                String login = "patient" + patientCount;
                Patient patient = new Patient(name, login);
                patientsList.add(patient);
                System.out.println("Запись добавлена.");
                System.out.println("Ваше имя в системе: " + patient.getName());
                System.out.println("Ваш логин: " + patient.getLogin());
                return patient;
            } else return null;


        }

    }}