package com.lucas.test.dto_test;

// No Lombok
public class SampleDTO {

    private Request request;
    private Response response;

    public SampleDTO(Request request, Response response) {
        this.request = request;
        this.response = response;
    }

    public SampleDTO() {
    }

    protected static class Request {
        private Long id;
        private String name;
        private String description;

        public Request(String number, String name, String desc) {
            this.id = Long.parseLong(number);
            this.name = name;
            this.description = desc;
        }
    }

    protected static class Response {
        private Long id;
        private String name;
        private String description;

        public Response(Long id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }

    // -------

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
