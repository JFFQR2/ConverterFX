package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Main extends Application {
private int heightM = 525;
private int height = 655;
private int widthM = 640;
    @Override
    public void start(Stage primaryStage) throws Exception {
        MyPanel root = new MyPanel();
        primaryStage.setTitle("Converter");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 720, height));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private class MyPanel extends FlowPane implements EventHandler {
        private ImageView icon = new ImageView(new Image(this.getClass().getResource("/resources/matrix_numbers.jpg").toString()));
        private ImageView icon0 = new ImageView(new Image(this.getClass().getResource("/resources/speed.jpg").toString()));
        private ImageView icon1 = new ImageView(new Image(this.getClass().getResource("/resources/temperature.jpg").toString()));
        private ImageView icon2 = new ImageView(new Image(this.getClass().getResource("/resources/CPU.jpg").toString()));
        private ImageView icon3 = new ImageView(new Image(this.getClass().getResource("/resources/mass.jpg").toString()));
        private ImageView icon4 = new ImageView(new Image(this.getClass().getResource("/resources/long.jpg").toString()));
        private ImageView icon5 = new ImageView(new Image(this.getClass().getResource("/resources/time.jpg").toString()));
        private ImageView icon6 = new ImageView(new Image(this.getClass().getResource("/resources/square.jpg").toString()));
        private ImageView icon8 = new ImageView(new Image(this.getClass().getResource("/resources/about.jpg").toString()));
        private ImageView icon7 = new ImageView(new Image(this.getClass().getResource("/resources/power.jpg").toString()));
        private ImageView[] icons = {icon, icon0, icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8};
        private Button[] button;
        private final String[] name = {"Объем Информации", "    Скорость", "      Температура      ",
                "    Частота  ", "            Масса            ", "    Длина    ", "            Время            ",
                "    Площадь", "         Мощность        ", "    About Us"};

        MyPanel() {
            button = new Button[10];
            for (int i = 0; i < button.length; i++) {
                button[i] = new Button(name[i]);
                button[i].setPrefSize(360, 120);
                button[i].setOnAction(this);
                button[i].setGraphic(icons[i]);
                getChildren().add(button[i]);
            }
        }

        private void action(final String s) {
            final ObservableList<String> inform = FXCollections.observableArrayList("Байт", "Килобайт", "Мегабайт", "Гигабайт", "Терабайт");
            final ObservableList<String> speed = FXCollections.observableArrayList("Метр в секунду", "Километр в час", "Миля в час", "Фут в секунду", "Узел");
            final ObservableList<String> temperature = FXCollections.observableArrayList("Цельсия", "Фаренгейт", "Кельвин");
            final ObservableList<String> frequency = FXCollections.observableArrayList("Герц", "Килогерц", "Мегагерц", "Гигагерц");
            final ObservableList<String> mass = FXCollections.observableArrayList("Килограмм", "Грамм", "Тонна", "Стоун", "Фунт", "Унция");
            final ObservableList<String> length = FXCollections.observableArrayList("Километр", "Метр", "Сантиметр", "Миллиметр", "Миля", "Ярд", "Фут", "Дюйм", "Морская миля");
            final ObservableList<String> time = FXCollections.observableArrayList("Милисекунда", "Секунда", "Минута", "Час", "Сутки", "Неделя", "Месяц", "Год", "Десятилетие", "Век");
            final ObservableList<String> square = FXCollections.observableArrayList("Квадратный километр", "Квадратный метр", "Квадратная миля", "Квадратный ярд", "Квадратный фут", "Квадратный дюйм", "Гектар", "Акр");
            final ObservableList<String> power = FXCollections.observableArrayList("Ватт", "КилоВатт", "Лошадиная Сила");
            if (s.equals(name[0]))
                converte(inform, "Объем Информации");
            else if (s.equals("    Скорость"))
                converte(speed, "Скорость");
            else if (s.equals("      Температура      "))
                converte(temperature, "Температура");
            else if (s.equals("    Частота  "))
                converte(frequency, "Частота");
            else if (s.equals("            Масса            "))
                converte(mass, "Масса");
            else if (s.equals("    Длина    "))
                converte(length, "Длина");
            else if (s.equals("            Время            "))
                converte(time, "Время");
            else if (s.equals("    Площадь"))
                converte(square, "Площадь");
            else if (s.equals("         Мощность        "))
                converte(power, "Мощность");
        }

        private void converte(final ObservableList<String> data, String title) {
            int width = 640;
            int height = 200;
            ListView<String> listIn = new ListView<>(data);
            ListView<String> listOut = new ListView<>(data);
            listIn.setPrefSize(150, 130);
            listOut.setPrefSize(150, 130);
            Label label = new Label();
            label.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 18));
            Label crutchLabel = new Label();
            crutchLabel.setPrefSize(40, 20);
            FlowPane frame = new FlowPane();
            TextField field = new TextField();
            field.setPrefSize(320, 20);
            if (title.equals("Объем Информации")) {
                width = 525;
                height = 130;
                field.setPrefSize(280, 20);
                listIn.setPrefSize(120, 80);
                listOut.setPrefSize(120, 80);
                listIn.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listIn.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 3) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            long result = Long.parseLong(field.getText()) / 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            long result = Long.parseLong(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            long result = Long.parseLong(field.getText()) * 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 3) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            long result = Long.parseLong(field.getText()) / 1024L / 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            long result = Long.parseLong(field.getText()) * 1024L * 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 3) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            long result = Long.parseLong(field.getText()) / 1024L / 1024L / 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            long result = Long.parseLong(field.getText()) * 1024L * 1024L * 1024L;
                            label.setText(String.valueOf(result));
                        } else if (n == 0 & listOut.getSelectionModel().getSelectedIndex() == 4) {
                            long result = Long.parseLong(field.getText()) / 1024L / 1024L / 1024L / 1024L;
                            label.setText(String.valueOf(result));
                        } else if (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 0) {
                            long result = Long.parseLong(field.getText()) * 1024L * 1024L * 1024L * 1024L;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
                listOut.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listOut.getSelectionModel().getSelectedIndex();
                        if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            long result = Long.parseLong(field.getText()) / 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            long result = Long.parseLong(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 3) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            long result = Long.parseLong(field.getText()) * 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            long result = Long.parseLong(field.getText()) / 1024L / 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 3) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            long result = Long.parseLong(field.getText()) * 1024L * 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            long result = Long.parseLong(field.getText()) / 1024L / 1024L / 1024L;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 3) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            long result = Long.parseLong(field.getText()) * 1024L * 1024L * 1024L;
                            label.setText(String.valueOf(result));
                        } else if (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 0) {
                            long result = Long.parseLong(field.getText()) / 1024L / 1024L / 1024L / 1024L;
                            label.setText(String.valueOf(result));
                        } else if (n == 0 & listIn.getSelectionModel().getSelectedIndex() == 4) {
                            long result = Long.parseLong(field.getText()) * 1024L * 1024L * 1024L * 1024L;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
            } else if (title.equals("Скорость")) {
                width = 585;
                height = 180;
                field.setPrefSize(280, 20);
                listIn.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listIn.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if (n == 0 & listOut.getSelectionModel().getSelectedIndex() == 1) {
                            double result = Double.parseDouble(field.getText()) * 3600D / 1000D;
                            label.setText(String.valueOf(result));
                        } else if (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 0) {
                            double result = Double.parseDouble(field.getText()) / 3600D * 1000D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1.60934D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 1.60934D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 2.23694D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 2.23694D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1.09728D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1.09728D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 3.28084D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 3.28084D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1.46667D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 1.46667D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1.852D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1.852D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1.68781D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1.68781D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 1.15078D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1.15078D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1.94384;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1.94384;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
                listOut.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listOut.getSelectionModel().getSelectedIndex();
                        if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 0) {
                            double result = Double.parseDouble(field.getText()) * 3600D / 1000D;
                            label.setText(String.valueOf(result));
                        } else if (n == 0 & listIn.getSelectionModel().getSelectedIndex() == 1) {
                            double result = Double.parseDouble(field.getText()) / 3600D * 1000D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 1.60934D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1.60934D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 2.23694D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 2.23694D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1.09728D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1.09728D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 3.28084D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 3.28084D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1.46667D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 1.46667D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1.852D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1.852D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1.68781D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1.68781D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 1.15078D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1.15078D;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1.94384;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1.94384;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
            } else if (title.equals("Температура")) {
                width = 505;
                height = 130;
                field.setPrefSize(280, 20);
                listIn.setPrefSize(110, 70);
                listOut.setPrefSize(110, 70);
                listIn.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listIn.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            long result = Long.parseLong(field.getText()) * 32;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            long result = Long.parseLong(field.getText()) / 32;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            long result = Long.parseLong(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 273.15;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 273.15;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 255.372;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 255.372;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
                listOut.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listOut.getSelectionModel().getSelectedIndex();
                        if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            long result = Long.parseLong(field.getText()) / 32;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            long result = Long.parseLong(field.getText()) * 32;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            long result = Long.parseLong(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 273.15;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 273.15;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 255.372;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 255.372;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
            } else if (title.equals("Частота")) {
                width = 505;
                height = 130;
                field.setPrefSize(280, 20);
                listIn.setPrefSize(110, 70);
                listOut.setPrefSize(110, 70);
                listIn.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listIn.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1e+6; //1000/1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1e+6; //1000*1000;
                            label.setText(String.valueOf(result));
                        } else if (n == 0 & listOut.getSelectionModel().getSelectedIndex() == 3) {
                            double result = Double.parseDouble(field.getText()) / 1e+9;//1000/1000/1000;
                            label.setText(String.valueOf(result));
                        } else if (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 0) {
                            double result = Double.parseDouble(field.getText()) * 1e+9; //1000*1000*1000;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
                listOut.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listOut.getSelectionModel().getSelectedIndex();
                        if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1e+6; //1000*1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1e+6; //1000/1000;
                            label.setText(String.valueOf(result));
                        } else if (n == 0 & listIn.getSelectionModel().getSelectedIndex() == 3) {
                            double result = Double.parseDouble(field.getText()) * 1e+9; //1000*1000*1000;
                            label.setText(String.valueOf(result));
                        } else if (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 0) {
                            double result = Double.parseDouble(field.getText()) / 1e+9; //1000/1000/1000;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
            } else if (title.equals("Масса")) {
                width = 525;
                height = 120;
                field.setPrefSize(280, 20);
                listIn.setPrefSize(120, 90);
                listOut.setPrefSize(120, 90);
                listIn.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listIn.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 4) | (n == 5 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 0 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 14;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 14;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 6.35029;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 6.35029;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 6350.29;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 6350.29;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 157.473;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 157.473;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 224;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 224;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 2.20462;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 2.20462;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 35.274;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 35.274;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1e+6; //1000*1000
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 1e+6; //1000/1000
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 2204.62;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 2204.62;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 35274;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 35274;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 453.592;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 453.592;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 16;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 16;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 28.3495;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 28.3495;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
                listOut.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listOut.getSelectionModel().getSelectedIndex();
                        if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 4) | (n == 5 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 0 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 14;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 14;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 6.35029;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 6.35029;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 6350.29;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 6350.29;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 157.473;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 157.473;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 224;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 224;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 2.20462;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 2.20462;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 35.274;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 35.274;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1e+6; //1000*1000
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 1e+6; //1000/1000
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 2204.62;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 2204.62;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 35274;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 35274;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 453.592;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 453.592;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 16;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 16;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 28.3495;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 28.3495;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
            } else if (title.equals("Длина")) {
                width = 545;
                height = 140;
                field.setPrefSize(280, 20);
                listIn.setPrefSize(130, 100);
                listOut.setPrefSize(130, 100);
                listIn.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listIn.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 4) | (n == 5 & listOut.getSelectionModel().getSelectedIndex() == 5) | (n == 6 & listOut.getSelectionModel().getSelectedIndex() == 6) | (n == 7 & listOut.getSelectionModel().getSelectedIndex() == 7) | (n == 8 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 100000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 100000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1.60934;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1.60934;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 1093.61;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1093.61;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 3280.84;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 3280.84;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 39370.1;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 39370.1;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 1.852;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1.852;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1609.34;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1609.34;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 1.09361;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1.09361;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 3.28084;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 3.28084;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 39.3701;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 39.3701;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1852;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 1852;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 160934;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 160934;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 91.44;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 91.44;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 30.48;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 30.48;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 2.54;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 2.54;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 185200;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 185200;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1.609e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1.609e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 914.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 914.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 304.8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 304.8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 25.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 25.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 1.852e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1.852e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 1760;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1760;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 5280;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 5280;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 63360;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 63360;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 1.15078;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1.15078;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 3;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 3;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 36;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 36;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 2025.37;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 2025.37;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 6076.12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 6076.12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 72913.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 72913.4;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
                listOut.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listOut.getSelectionModel().getSelectedIndex();
                        if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 4) | (n == 5 & listIn.getSelectionModel().getSelectedIndex() == 5) | (n == 6 & listIn.getSelectionModel().getSelectedIndex() == 6) | (n == 7 & listIn.getSelectionModel().getSelectedIndex() == 7) | (n == 8 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 100000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 100000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1.60934;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1.60934;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 1093.61;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1093.61;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 3280.84;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 3280.84;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 39370.1;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 39370.1;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 1.852;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1.852;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1609.34;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1609.34;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 1.09361;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1.09361;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 3.28084;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 3.28084;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 39.3701;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 39.3701;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1852;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 1852;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 160934;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 160934;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 91.44;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 91.44;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 30.48;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 30.48;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 2.54;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 2.54;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 185200;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 185200;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1.609e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1.609e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 914.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 914.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 304.8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 304.8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 25.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 25.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 1.852e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1.852e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 1760;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1760;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 5280;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 5280;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 63360;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 63360;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 1.15078;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1.15078;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 3;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 3;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 36;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 36;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 2025.37;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 2025.37;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 6076.12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 6076.12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 72913.4;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 72913.4;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
            } else if (title.equals("Время")) {
                width = 545;
                height = 140;
                field.setPrefSize(280, 20);
                listIn.setPrefSize(130, 100);
                listOut.setPrefSize(130, 100);
                listIn.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listIn.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 4) | (n == 5 & listOut.getSelectionModel().getSelectedIndex() == 5) | (n == 6 & listOut.getSelectionModel().getSelectedIndex() == 6) | (n == 7 & listOut.getSelectionModel().getSelectedIndex() == 7) | (n == 8 & listOut.getSelectionModel().getSelectedIndex() == 8) | (n == 9 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 60000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 60000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 3.6e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 3.6e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 8.64e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 8.64e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 6.048e+8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 6.048e+8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 2.628e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 2.628e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+11;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+11;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 60;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 60;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 3600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 3600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 86400;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 86400;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 604800;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 604800;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 2.628e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 2.628e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1440;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 1440;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 10080;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 10080;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 43800;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 43800;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 525600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 525600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 5.256e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 5.256e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 5.256e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) / 5.256e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 24;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 24;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 168;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 168;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 730.001;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 730.001;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 8760;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 8760;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 87600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 87600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 876000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) / 876000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 30.4167;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 30.4167;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 365;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 365;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 3650;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 3650;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) / 36500;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 36500;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 4.34524;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 4.34524;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 52.1429;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 52.1429;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 521.429;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 521.429;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 5214.29;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) / 5214.29;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 120;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 120;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) / 1200;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 1200;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 8) | (n == 8 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) / 10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listOut.getSelectionModel().getSelectedIndex() == 7) | (n == 9 & listOut.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) / 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 100;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
                listOut.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listOut.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 4) | (n == 5 & listIn.getSelectionModel().getSelectedIndex() == 5) | (n == 6 & listIn.getSelectionModel().getSelectedIndex() == 6) | (n == 7 & listIn.getSelectionModel().getSelectedIndex() == 7) | (n == 8 & listIn.getSelectionModel().getSelectedIndex() == 8) | (n == 9 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 60000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 60000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 3.6e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 3.6e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 8.64e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 8.64e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 6.048e+8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 6.048e+8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 2.628e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 2.628e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+11;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+11;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 60;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 60;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 3600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 3600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 86400;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 86400;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 604800;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 604800;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 2.628e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 2.628e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+8;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 3.154e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) * 3.154e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1440;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 1440;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 10080;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 10080;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 43800;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 43800;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 525600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 525600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 5.256e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 5.256e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 5.256e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) * 5.256e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 24;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 24;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 168;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 168;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 730.001;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 730.001;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 8760;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 8760;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 87600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 87600;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 876000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) * 876000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 30.4167;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 30.4167;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 365;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 365;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 3650;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 3650;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) * 36500;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 36500;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 4.34524;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 4.34524;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 52.1429;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 52.1429;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 521.429;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 521.429;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 5214.29;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) * 5214.29;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 12;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 120;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) * 120;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) * 1200;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 1200;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 8) | (n == 8 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) * 10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 8 & listIn.getSelectionModel().getSelectedIndex() == 7) | (n == 9 & listIn.getSelectionModel().getSelectedIndex() == 8)) {
                            double result = Double.parseDouble(field.getText()) / 10;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 9)) {
                            double result = Double.parseDouble(field.getText()) * 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 9 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 100;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
            } else if (title.equals("Площадь")) {
                width = 655;
                height = 150;
                field.setPrefSize(280, 20);
                listIn.setPrefSize(185, 100);
                listOut.setPrefSize(185, 100);
                listIn.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listIn.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listOut.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listOut.getSelectionModel().getSelectedIndex() == 4) | (n == 5 & listOut.getSelectionModel().getSelectedIndex() == 5) | (n == 6 & listOut.getSelectionModel().getSelectedIndex() == 6) | (n == 7 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 2.58999;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 2.58999;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1.196e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1.196e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1.076e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 1.076e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 1.55e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1.55e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 247.105;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 247.105;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 2.59e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 2.59e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1.19599;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1.19599;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 10.7639;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 10.7639;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 1550;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1550;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 10000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 10000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 4046.86;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 4046.86;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 3.098e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 3.098e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 2.788e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 2.788e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 4.014e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 4.014e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 258.999;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 258.999;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 640;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 640;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 1296;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1296;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 11959.9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 11959.9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 4840;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 4840;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 144;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 144;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 107639;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 107639;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 43560;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 43560;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 1.55e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 1.55e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 6.273e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) * 6.273e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listOut.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 2.47105;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listOut.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 2.47105;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
                listOut.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listOut.getSelectionModel().getSelectedIndex();
                        if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 2) | (n == 3 & listIn.getSelectionModel().getSelectedIndex() == 3) | (n == 4 & listIn.getSelectionModel().getSelectedIndex() == 4) | (n == 5 & listIn.getSelectionModel().getSelectedIndex() == 5) | (n == 6 & listIn.getSelectionModel().getSelectedIndex() == 6) | (n == 7 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 2.58999;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 2.58999;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1.196e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1.196e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1.076e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 1.076e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 1.55e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1.55e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 100;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 247.105;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 247.105;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 2.59e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 2.59e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 1.19599;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1.19599;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 10.7639;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 10.7639;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 1550;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1550;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 10000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 10000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 4046.86;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 4046.86;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 3.098e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 3.098e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 2.788e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 2.788e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 4.014e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 4.014e+9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 258.999;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) / 258.999;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 640;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 640;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 1296;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) * 1296;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 11959.9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 11959.9;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 3)) {
                            double result = Double.parseDouble(field.getText()) / 4840;
                            label.setText(String.valueOf(result));
                        } else if ((n == 3 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 4840;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) * 144;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 144;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 107639;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 107639;
                            label.setText(String.valueOf(result));
                        } else if ((n == 4 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 43560;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 4)) {
                            double result = Double.parseDouble(field.getText()) / 43560;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 1.55e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 1.55e+7;
                            label.setText(String.valueOf(result));
                        } else if ((n == 5 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) * 6.273e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 5)) {
                            double result = Double.parseDouble(field.getText()) / 6.273e+6;
                            label.setText(String.valueOf(result));
                        } else if ((n == 6 & listIn.getSelectionModel().getSelectedIndex() == 7)) {
                            double result = Double.parseDouble(field.getText()) / 2.47105;
                            label.setText(String.valueOf(result));
                        } else if ((n == 7 & listIn.getSelectionModel().getSelectedIndex() == 6)) {
                            double result = Double.parseDouble(field.getText()) * 2.47105;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
            } else if (title.equals("Мощность")) {
                width = 585;
                height = 130;
                field.setPrefSize(280, 20);
                listIn.setPrefSize(150, 80);
                listOut.setPrefSize(150, 80);
                listIn.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listIn.getSelectionModel().getSelectedIndex();
                        if (field.getText().isEmpty()) {
                            field.setText("0");
                        }
                        if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listOut.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 735.499;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) * 735.499;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listOut.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 1.35962;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listOut.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) / 1.35962;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
                listOut.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                    @Override
                    public void onChanged(Change<? extends Integer> c) {
                        int n = listOut.getSelectionModel().getSelectedIndex();
                        if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 0) | (n == 1 & listIn.getSelectionModel().getSelectedIndex() == 1) | (n == 2 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText());
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1000;
                            label.setText(String.valueOf(result));
                        } else if ((n == 0 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) * 735.499;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 0)) {
                            double result = Double.parseDouble(field.getText()) / 735.499;
                            label.setText(String.valueOf(result));
                        } else if ((n == 1 & listIn.getSelectionModel().getSelectedIndex() == 2)) {
                            double result = Double.parseDouble(field.getText()) / 1.35962;
                            label.setText(String.valueOf(result));
                        } else if ((n == 2 & listIn.getSelectionModel().getSelectedIndex() == 1)) {
                            double result = Double.parseDouble(field.getText()) * 1.35962;
                            label.setText(String.valueOf(result));
                        }
                    }
                });
            }
            frame.getChildren().add(field);
            frame.getChildren().add(new ScrollPane(listIn));
            frame.getChildren().add(new ScrollPane(listOut));
            frame.getChildren().add(crutchLabel);
            frame.getChildren().add(label);
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setResizable(false);
            stage.setScene(new Scene(frame, width, height));
            stage.show();
        }

        @Override
        public void handle(Event event) {
            if (event.getSource() == button[0]) {
                action(name[0]);
            } else if (event.getSource() == button[1]) {
                action(name[1]);
            } else if (event.getSource() == button[2]) {
                action(name[2]);
            } else if (event.getSource() == button[3]) {
                action(name[3]);
            } else if (event.getSource() == button[4]) {
                action(name[4]);
            } else if (event.getSource() == button[5]) {
                action(name[5]);
            } else if (event.getSource() == button[6]) {
                action(name[6]);
            } else if (event.getSource() == button[7]) {
                action(name[7]);
            } else if (event.getSource() == button[8]) {
                action(name[8]);
            } else if (event.getSource() == button[9]) {
                Stage frame = new Stage();
                frame.setTitle("О программе");
                FlowPane pane = new FlowPane();
                Label label = new Label("          Converter 0.2");
                label.setFont(Font.font("Verdana",FontWeight.BOLD,18));
                label.setTextAlignment(TextAlignment.CENTER);
                Label jLabel = new Label("   Created by Quite River 07.04.2017");
                jLabel.setFont(Font.font("Sans Serif", FontPosture.ITALIC,14));
                pane.getChildren().add(label);
                pane.getChildren().add(jLabel);
                frame.setScene(new Scene(pane,280,70));
                frame.setResizable(false);
                frame.show();
            }
        }
    }
}
