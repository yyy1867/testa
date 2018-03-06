package ml.guxing.demo.spring;

/**
 * 原型模式
 */
public class PrototypeMode {

    public static void main(String[] args) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("测试试题0");
        System.out.println(testEntity);
        Object d2 = testEntity.clone();
        System.out.println(d2);
    }

    public static class TestEntity {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "TestEntity{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        protected Object clone() {
            TestEntity testEntity = new TestEntity();
            testEntity.setName(name);
            return testEntity;
        }
    }

}
