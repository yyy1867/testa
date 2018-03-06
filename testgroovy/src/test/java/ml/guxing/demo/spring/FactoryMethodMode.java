package ml.guxing.demo.spring;

/**
 * 工厂方法模式
 */
public class FactoryMethodMode {

    public static void main(String[] args) {
        TestEntity testEntity = TestEntityFactory.getTestEntity(null, "testcode");
        System.out.println(testEntity);
    }

    private static class TestEntity {
        private String name;
        private String code;

        public TestEntity(String name, String code) {
            this.name = name;
            this.code = code;
        }

        @Override
        public String toString() {
            return "TestEntity{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }

    }

    private static class TestEntityFactory {
        private static String defaultName = "测试名称";

        public static TestEntity getTestEntity(String name, String code) {
            if (name == null) {
                name = defaultName;
            }
            return new TestEntity(name, code);
        }
    }

}
