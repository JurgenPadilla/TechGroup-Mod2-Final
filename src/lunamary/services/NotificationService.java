package lunamary.services;

import datastructures.circulardoublylinkedlist.MyCircularDoublyLinkedList;
import datastructures.linkedlist.MyLinkedList;
import lunamary.model.modelPerson.*;
import lunamary.model.modelSchool.Classroom;

import java.util.HashMap;
import java.util.Map;

import static lunamary.services.SchoolService.getSchoolService;

public class NotificationService {
    private SubjectObservable subjectObservable;

    public NotificationService() {
        subjectObservable = new SubjectObservable();

    }


    public void registerObservers() {

        HashMap<String, MyLinkedList<Kardex>> listHash = getSchoolService().getKardexHashMap();
        if (listHash.size() > 0) {
            for (Map.Entry<String, MyLinkedList<Kardex>> listHashlist : listHash.entrySet()) {
                MyLinkedList<Kardex> kardexList = listHashlist.getValue();
                if (kardexList.size() > 0) {
                    for (int j = 0; j < kardexList.size(); j++) {
                        Student student = (Student) kardexList.get(j).getStudent();
                        String template = getTemplate(student);
                        MyCircularDoublyLinkedList<Parent> parentList = student.getParents();
                        for (int k = 0; k < parentList.size(); k++) {
                            Parent parent = (Parent) parentList.get(k);
                            Device device = parent.getDevice();
                            device.setTemplateMsj(template);
                            IObserver iObserver = new DeviceService(device);
                            subjectObservable.registerObserver(iObserver);

                        }

                    }

                }
            }
        }
    }


    private String getTemplate(Student student) {

        String template = null;

        if (student.getStatus().equals("EXPELLED")) {
            template = "The student is EXPELLED :(";
        } else if (student.getStatus().equals("FAILED")) {
            template = "The student is FAILED :(";
        } else if (student.getStatus().equals("PASSED")) {
            template = "The student is PASSED :) ";
        } else if (student.getStatus().equals("SCHOLAR")) {
            template = "The student is SCHOLAR! :D ";
        }
        return template;

    }


    public void notifyObservers() {
        subjectObservable.notifyObservers();
    }

}

