package ru.fadeev.UserPanel;


import static ru.fadeev.UserPanel.CheckInput.createArrInt;
import static ru.fadeev.UserPanel.CheckInput.inputDouble;
import static ru.fadeev.UserPanel.CheckInput.inputInt;
import static ru.fadeev.UserPanel.CheckInput.inputIntRange;
import static ru.fadeev.UserPanel.CheckInput.inputIntRangeMin;
import static ru.fadeev.UserPanel.CheckInput.inputString;
import static ru.fadeev.UserPanel.CheckInput.passStr;

import ru.fadeev.master.Calculator;
import ru.fadeev.master.FractionalValue;
import ru.fadeev.master.IntValue;
import ru.fadeev.master.RationalValue;
import ru.fadeev.ImmutableListOfValues.ImmutableListOfValues;
import ru.fadeev.master.NumericValue;
import ru.fadeev.geometry.AbstractPoint.Point1Dim;
import ru.fadeev.geometry.AbstractPoint.Point2Dim;
import ru.fadeev.geometry.AbstractPoint.Point3Dim;
import ru.fadeev.geometry.Line;
import ru.fadeev.geometry.PointDefault.Point;
import ru.fadeev.geometry.PointDefault.Point3D;
import ru.fadeev.geometry.Polyline;
import ru.fadeev.geometry.Square;

public class UserPanel {

	private static NumericValue inputForCalculator() {
		while (true) {
			String input = inputString("Введите число (целое, дробь A/B или вещественное): ", false);

			if (input.isEmpty()) {
				System.out.println("Ввод не может быть пустым.");
				continue;
			}

			try {
				if (input.contains("/")) {
					String[] parts = input.split("/");
					if (parts.length != 2) {
						throw new IllegalArgumentException("Дробь должна быть в формате A/B");
					}
					int num = Integer.parseInt(parts[0].trim());
					int den = Integer.parseInt(parts[1].trim());
					if (den == 0) {
						throw new IllegalArgumentException("Знаменатель не может быть нулём");
					}
					return new RationalValue(num, den);
				} else if (input.contains(".")) {
					double d = Double.parseDouble(input);
					return new FractionalValue(d);
				} else {
					int i = Integer.parseInt(input);
					return new IntValue(i);
				}
			} catch (NumberFormatException e) {
				System.out.println("Ошибка: введено не число. Примеры: 5, 3.14, 2/3");
			} catch (IllegalArgumentException e) {
				System.out.println("Ошибка: " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Неизвестная ошибка: " + e.getMessage());
			}
		}
	}

	private Point createPoint2D() {
		double x = inputDouble("Введите значение x: "), y = inputDouble("Введите значение y: ");
		return new Point(x, y);
	}

	private void changePoint(Point point) {
		double x = inputDouble("Введите новое значение x: "), y = inputDouble(
				"Введите новое значение y: ");
		point.setX(x);
		point.setY(y);
	}

	// Задача 1.6
	private void t16() {
		System.out.println("");
		System.out.println("Задание 1.6");

		System.out.println("Введите координаты точки начала линии:");
		Point pStart = createPoint2D();
		System.out.println("Введите координаты точки конца линии:");
		Point pEnd = createPoint2D();
		Line line1 = new Line(pStart, pEnd);
		System.out.println("1 " + line1);
		System.out.print("\n");

		Line line2 = new Line(pStart, pEnd);
		System.out.println("Создание 2-ой линии на тех же координатах:" + line2);
		System.out.print("\n");

		System.out.println("Изменение точки начала линии 1: ");
		changePoint(line1.getStart()); // Запрос точки начала
		System.out.println("Изменение точки конца линии 1: ");
		changePoint(line1.getEnd());// Запрос точки конца
		System.out.print("\n");

		System.out.println("Изменение точки начала линии 2: ");
		changePoint(line2.getStart());
		System.out.println("Изменение точки конца линии 2: ");
		changePoint(line2.getEnd());
		System.out.print("\n");

		System.out.println("После изменения 1 " + line1);
		System.out.println("После изменения 2 " + line2);
		System.out.print("\n");

	}

	private void t112() {
		System.out.println("Задание 1.12");
		Square square = new Square(inputDouble("Введите координату x левой верхней точки квадрата: "),
				inputDouble("Введите координату y левой верхней точки квадрата: "),
				inputIntRangeMin("Введите длинну стороны квадрата квадрата: ", 0));
		System.out.println(
				"Присвоение ссылке типа Ломаная результата вызова метода получения Ломаной у "
						+ "созданного квадрата");
		Polyline figureSquare = square.getPolyline();
		System.out.print("Общая длина полученной Ломаной: ");
		System.out.println(figureSquare.getLength());
		System.out.print("\n");

		figureSquare.changePoint(
				inputIntRange("Введите индекс точки ломаной от 1 до " + figureSquare.contOfIndex()
						+ ", в которую нужно ввести новые координаты: ", 0, figureSquare.contOfIndex() + 1) - 1,
				inputDouble("Введите новый x: "),
				inputDouble("Введите новый y: ")
		);
		System.out.print("\n");

		System.out.print("Общая длина полученной Ломаной с измененной координатой: ");
		System.out.println(figureSquare.getLength());

//		Polyline figureSquare1 = square.getPolyline();
//		System.out.println(figureSquare1.getLength());
		System.out.print("\n");
	}

	private void t21() {
		System.out.println("Задание 2.1");
		// 1. Создание из массива

		int[] data = createArrInt();
		ImmutableListOfValues list1 = new ImmutableListOfValues(data);
		System.out.println("list1: " + list1);

		// 2. Создание через перечень чисел
		System.out.println("\nСоздание массива 2: ");
		ImmutableListOfValues list2 = new ImmutableListOfValues(inputInt("Введите 1 число: "),
				inputInt("Введите 2 число: "), inputInt("Введите 3 число: "));
		System.out.println("\nСоздание массива: ...");
		System.out.println("list2: " + list2);
		System.out.print("\n");

		// 3. Создание копии другого списка
		System.out.println("Копирование 2-го массива в новый 3 массив: ...");
		ImmutableListOfValues list3 = new ImmutableListOfValues(list2);
		System.out.println("list3 (копия list2): " + list3);
		System.out.print("\n");

		//4. Получение элемента
		//System.out.println(list1.getValue(100));
		System.out.println("Значение 1-го элемента списка list1: " + list1.getValue(
				inputIntRange("Введите индекс элемента списка 1 от 1 до " + list1.size()
						+ ", который нужно получить: ", 0, list1.size() + 1) - 1));
		System.out.print("\n");

		// 5. Изменение значения
		list2.setValue(inputIntRange("Введите индекс элемента списка 2 от 1 до " + list2.size()
						+ ", который нужно заменить: ", 0, list2.size() + 1) - 1,
				inputInt("Введите новое значение элемента: "));
		System.out.println("list2 после изменения: " + list2);
		// Проверка: list3 не изменился (независимая копия)
		System.out.println("list3 всё ещё: " + list3);
		System.out.print("\n");

		// 6. Проверка на пустоту
		System.out.println("Проверка на пустоту list3: ");
		System.out.println("Список list3 пуст: " + list3.isEmpty());
		System.out.print("\n");

		// 7. Текущий размер
		System.out.println("Текущий размер list1: " + list1.size());

		//8 Запрос на все хранящиеся значения в виде стандартного массива.
		int[] arrCopy = list2.getList();
		System.out.print("\n");

	}

	private void t35() {
		System.out.println("Задание 3.5");
		System.out.print("\n");

		System.out.println("Создание точки в трехмерном пространстве: ");
		Point3D point3d1 = new Point3D(inputDouble("Введите x: "), inputDouble("Введите y: "),
				inputDouble("Введите z: "));
		System.out.println("point 1: " + point3d1);
		System.out.print("\n");

		System.out.println("Создание 2 точки на основе предыдущей:... ");
		Point3D point3d2 = new Point3D(point3d1);
		System.out.println("point 2: " + point3d2);
		System.out.print("\n");

		point3d2.setY(inputDouble("Введите новое значение y точки point3d2: "));
		System.out.print("\n");
		System.out.println("point 1: " + point3d1);
		System.out.println("point 2: " + point3d2);
		System.out.print("\n");
	}

	private void t45() {
		System.out.println("4.5");

		System.out.println("Создание точки в 1 мерном пространстве: ");
		Point1Dim point1D = new Point1Dim(inputInt("Введите координату точки: "),
				inputString("Введите цвет точки: ", true), null);
		System.out.print("\n");

		System.out.println("Создание точки в 3 мерном пространстве: ");
		Point3Dim point3D = new Point3Dim(inputInt("Введите координату x точки: "),
				inputInt("Введите координату y точки: "), inputInt("Введите координату z точки: "), null,
				inputString("Введите время создания точки: ", true));
		System.out.print("\n");

		System.out.println("Создание точки в 2 мерном пространстве: ");
		Point2Dim point2D = new Point2Dim(inputInt("Введите координату x точки: "),
				inputInt("Введите координату y точки: "),
				inputString("Введите цвет точки: ", true), inputString("Введите время создания точки: ", false));
		System.out.print("\n");

		System.out.println(point1D);
		System.out.println(point2D);
		System.out.println(point3D);

		System.out.print("\n");
	}

	private void t51() {
		System.out.println("Задание 5.1");
		int len = inputIntRangeMin("Сколько чисел вы хотите сложить: ", 0);
		passStr();
		NumericValue[] numbers = new NumericValue[len];
		for (int i = 0; i < len; i++) {
			System.out.println("\nВвод " + (i + 1) +"-го числа ");
			numbers[i] = inputForCalculator();
		}
		System.out.print("\n");
		double result = Calculator.sum(numbers);
		System.out.println("Сумма введенных чисел: "+ result);
		System.out.print("\n");
	}

	private void t63() {
		System.out.println("Задание 6.3");

		System.out.println("Введите точку начала и конца линии 1: ");
		Line l1 = new Line(createPoint2D(), createPoint2D());
		System.out.println("Введите точку начала и конца линии 2: ");
		Line l2 = new Line(createPoint2D(), createPoint2D());
		System.out.print("\n");

		System.out.println("1 " + l1);
		System.out.println("2 " + l2);

		boolean equals = l1.equals(l2);
		System.out.println("Линия 1 и линия 2 равны? - " + equals);
		System.out.print("\n");
	}

	private void t85() throws CloneNotSupportedException {
		System.out.println("Задание 8.5");

		System.out.println("Введите точку начала и конца линии 1: ");
		Line l1 = new Line(createPoint2D(), createPoint2D());
		System.out.println("Копирование в линию 2 линию 1: ");
		Line l2 = l1.clone();  //throws CloneNotSupportedException у main отсюда
		System.out.print("\n");

		System.out.println("1 " + l1);
		System.out.println("2 " + l2);
		System.out.print("\n");

		boolean l12 = l1==l2;
		System.out.println("Содержимое в линиях 1 и 2 одинаковое? - " + l1.equals(l2)); // сравнение содержимого
		System.out.println("Линии 1 и 2 одна и та же? - " + l12);      // сравнение ссылок
		System.out.print("\n");

		l1.getStart().setY(inputDouble("Введите новое значение y точки начала линии 1: "));
		System.out.print("\n");

		System.out.println("1 " + l1);
		System.out.println("2 " + l2);
		System.out.print("\n");

		System.out.println("Содержимое в линиях 1 и 2 одинаковое? - " + l1.equals(l2));
		System.out.print("\n");
	}

	public void choiceTask() throws CloneNotSupportedException {
		int task = 0;
		System.out.println("Выберите задание: ");
		System.out.println(
				"1 - Задание 1.6\n2 - Задание 1.12\n3 - Задание 2.1\n4 - Задание 3.5\n5 - Задание 4.5\n6 - Задание 5.1\n7 - Задание 6.3\n8 - Задание 8.5");
		task = inputIntRange("Введите номер задачи от 1 до 8: ", 0, 9);

		switch (task) {
			case 1:
				t16();
				break;
			case 2:
				t112();
				break;
			case 3:
				t21();
				break;
			case 4:
				t35();
				break;
			case 5:
				t45();
				break;
			case 6:
				t51();
				break;
			case 7:
				t63();
				break;
			case 8:
				t85(); //throws
				break;
		}
	}
}
