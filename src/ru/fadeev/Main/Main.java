package ru.fadeev.Main;

import static ru.fadeev.UserPanel.CheckInput.inputIntRange;

import ru.fadeev.UserPanel.UserPanel;

public class Main {

	static void main(String[] args) throws CloneNotSupportedException {//7.3 java src/ru/fadeev/Calculator/Calculator.java 2 2
		UserPanel panel = new UserPanel();
		boolean panelCycle = true;
		int cycle;
		while (panelCycle) {
			panel.choiceTask();
			cycle = inputIntRange("Начать заново?\nДа- 1\nНет-0\n->", -1, 2);
			if (cycle == 1) {
				//Цикл продолжится
			} else {
				panelCycle = false;
			}
		}
	}
}
