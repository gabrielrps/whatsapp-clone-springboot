package br.com.gabrielrps.whatsappclonespringboot.repository;

import br.com.gabrielrps.whatsappclonespringboot.document.MessageContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageContentRepository extends CrudRepository<MessageContent, String> {
}
