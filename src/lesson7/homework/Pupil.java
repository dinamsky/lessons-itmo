package lesson7.homework;

public class Pupil {

        private int id;
        private ExamResult[] examResults;

        public Pupil(int id) {
            this.id = id;
        }

        public void setExams(String[] exams, int[] grade) {
            if (exams.length == grade.length) {
                examResults = new ExamResult[exams.length];
                for (int i = 0; i < grade.length; i++) {
                    if (grade[i] < 1 && grade[i] > 5) {
                        System.out.println("Оценки должны быть в диапазоне от 1 до 5");
                        return;
                    }
                    else {
                        examResults[i] = new ExamResult(exams[i], grade[i]);

                    }
                }
            }
            else System.out.println("Количество предметов не совпадает с количеством оценок");
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < examResults.length; i++) {

                stringBuilder.append("\n");
                stringBuilder.append(examResults[i]);

            }
            return "Студент: " +
                    id +
                    stringBuilder;
        }

        private class ExamResult {

            String object;
            int grade;
            boolean status;


            public ExamResult(String object, int grade) {
                this.status = grade > 2;
                this.object = object;
                this.grade = grade;
            }

            @Override
            public String toString() {
                return object + (status ? " сдал" : " не сдал");
            }
        }








    }

