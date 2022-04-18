package lpnt.cg.service;

import lpnt.cg.model.Message;

import java.util.List;

public interface IMessageService {

    List<Message> findAll();

    Message findById(Long id);

    void save(Message customer);

    void remove(Long id);
}