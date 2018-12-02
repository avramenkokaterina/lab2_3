package main.java.avramenko.controller;

import main.java.avramenko.model.*;
import main.java.avramenko.validator.*;
import main.java.avramenko.view.*;

import java.util.*;

public class Controller {

    private Model model;
    private View view;
    private Validator validator;
    private Set<Point> pointsSet;
    private Point point;

    Controller() {
        model = new Model();
        view = new View();
        validator = new Validator();
    }

    public void startWorking() {
        Activities activities;
        activities = Activities.SHOW_MENU;
        while (true) {
            switch (activities) {
                case SHOW_MENU:
                    activities = showMenu();
                    break;
                case CREATE_COLLECTION:
                    activities = createCollection();
                    break;
                case GENERATE_COLLECTION:
                    activities = generateCollection();
                    break;
                case FIND_MAX_TRIANGLE:
                    activities = findTriangle();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private Activities convertToChoice(int choice) {
        switch (choice) {
            case 1:
                return Activities.CREATE_COLLECTION;
            case 2:
                return Activities.GENERATE_COLLECTION;
            case 3:
                return Activities.EXIT;
        }
        return null;
    }

    private Activities showMenu() {
        view.printMenu();
        int choice;
        choice = view.readNumber();
        do {
            try {
                if (!validator.checkMenuChoice(choice).isEmpty()) {
                    throw new InvalidInputException(validator.checkMenuChoice(choice));
                }
            } catch (InvalidInputException iie) {
                System.out.println(iie.getMessage());
                choice = view.readNumber();
            }
        } while (!validator.checkMenuChoice(choice).isEmpty());
        return convertToChoice(choice);
    }

    private Activities createCollection() {
        int length;
        int x;
        int y;

        view.printMessage(Messages.ENTER_AMOUNT);
        length = view.readNumber();
        do {
            try {
                if (!validator.checkLength(length).isEmpty()) {
                    throw new InvalidInputException(validator.checkLength(length));
                }
            } catch (InvalidInputException iie) {
                System.out.println(iie.getMessage());
                length = view.readNumber();
            }
        } while (!validator.checkLength(length).isEmpty());

        for (int i = 0; i < length; i++) {
            point = new Point();
            view.printMessage(Messages.ENTER_POINT_X);
            x = view.readCoordinate();
            view.printMessage(Messages.ENTER_POINT_Y);
            y = view.readCoordinate();
            point = new Point(x, y);

            if (model.getPointsSet().contains(point)) {
                view.printMessage(Messages.POINT_ALREADY_EXIST);
                i --;
            } else {
                model.getPointsSet().add(point);
            }

        }
        pointsSet = model.getPointsSet();
        showCollection(pointsSet);
        return Activities.FIND_MAX_TRIANGLE;
    }

    private Activities generateCollection() {
        pointsSet = new HashSet<>();
        pointsSet = model.generateSetOfPoints();
        showCollection(pointsSet);
        return Activities.FIND_MAX_TRIANGLE;
    }

    private Activities findTriangle() {
        view.printMessage(Messages.RESULT);
        view.printResult(model.getTriangle());
        return Activities.SHOW_MENU;
    }

    private void showCollection(Set<Point> pointsSet) {
        view.printCollection(pointsSet);
    }
}
