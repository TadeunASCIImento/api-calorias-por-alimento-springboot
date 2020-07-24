package br.com.application.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import br.com.application.recursos.Alimento;

@Repository
public class AlimentoRepository {

	private static MongoCollection<Document> getCollection() {
		try {
			ConnectionString connectionString = new ConnectionString(
					"mongodb+srv://USER_NAME:<password>@cluster0.g738r.mongodb.net/<dbname>?retryWrites=true&w=majority");
			MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString)
					.retryWrites(true).build();
			MongoClient mongoClient = MongoClients.create(settings);
			MongoDatabase db = mongoClient.getDatabase("db_alimentos");
			return db.getCollection("alimentos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Alimento> findByDescricao(String descricao) {
		List<Alimento> alimentos = new ArrayList<Alimento>();
		try (MongoCursor<Document> cursor = getCollection().find().iterator()) {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				if (doc.getString("Alimento").contains(descricao) && descricao.length() > 2) {
					Alimento alimento = new Alimento();
					alimento.setId(doc.get("_id"));
					alimento.setDescricao(doc.getString("Alimento"));
					alimento.setQuantidade(doc.getString("Porção"));
					alimento.setCalorias(doc.getString("Calorias"));
					alimentos.add(alimento);

				}
			}
		}
		return alimentos;
	}

}
