package request;

import common.RequestDataStore;

public class RequestManger extends RequestDataStore {
    public void addRequest(BookRequest request) {
        getRequestList().add(request);
    }
}
