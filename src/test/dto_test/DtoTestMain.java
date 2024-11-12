package test.dto_test;

public class DtoTestMain {
    public static void main(String[] args) {
        SampleDTO dto = new SampleDTO();
        dto.setRequest(new SampleDTO.Request("1", "name", "desc"));

        // If Builder is Available
//        SampleDTO dto = new SampleDTO().Request.builder().id(1L).name("name").description("desc").build(); // use This Patterns
    }
}
