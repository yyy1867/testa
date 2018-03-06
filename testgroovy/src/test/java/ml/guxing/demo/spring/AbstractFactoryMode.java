package ml.guxing.demo.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象工厂模式
 */
public class AbstractFactoryMode {

    public static void main(String[] args) {
        ModelFactory modelFactory = new ModelFactoryImpl();
        modelFactory.getField().println();
        modelFactory.getTable().println();
        modelFactory.getField().println();
        modelFactory.getTable().println();
    }

    private static abstract class TestModel {
        public abstract void println();
    }

    private static abstract class ModelFactory {
        public abstract TestModel getTable();

        public abstract TestModel getField();
    }

    private static class ModelFactoryImpl extends ModelFactory {

        private List<Field> fields = new ArrayList<Field>();

        @Override
        public TestModel getTable() {
            return new Table(fields.size());
        }

        @Override
        public TestModel getField() {
            fields.add(new Field());
            return fields.get(fields.size() - 1);
        }
    }

    private static class Table extends TestModel {

        private int count;

        public Table(int count) {
            this.count = count;
        }

        @Override
        public void println() {
            System.out.println("这是一个表,包含了" + count + "个字段!");
        }
    }

    private static class Field extends TestModel {

        @Override
        public void println() {
            System.out.println("这是一个字段");
        }
    }

}
