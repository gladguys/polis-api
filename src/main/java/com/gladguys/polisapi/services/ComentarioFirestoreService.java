package com.gladguys.polisapi.services;

import com.gladguys.polisapi.models.Comentario;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Service;

@Service
public class ComentarioFirestoreService {

    private final Firestore db;

    public ComentarioFirestoreService(Firestore db) {
        this.db = db;
    }

    public void incrementarContadorComentarios(Comentario comentario) {
        db.collection("atividades")
                .document(comentario.getPoliticoId())
                .collection("atividadesPolitico")
                .document(comentario.getPostId())
                .update("qntComentarios", FieldValue.increment(1));
    }
}
