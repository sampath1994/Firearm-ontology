package application;

import java.util.ArrayList;
import java.util.List;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;



public class FirearmOntology {

	public List<Gun> findWeaponWithAllFunc() {
		
		FileManager.get().addLocatorClassLoader(FirearmOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("fa2.owl");
        //  model.write(System.out,"TURTLE");

        List<Gun> gunList = new ArrayList<Gun>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX ex: <http://www.semanticweb.org/promod/ontologies/2019/6/firearm#> " +
                "SELECT DISTINCT ?subject ?weight ?range ?fireRate ?price " +
                "WHERE { ?subject ex:hasFunction ?bases ."+
                "?subject ex:hasWeight ?weight ."+
                "?subject ex:hasRange ?range ."+
                "?subject ex:hasFireRate ?fireRate ."+
                "?subject ex:hasPrice ?price"
                + "}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource subject = solution.getResource("subject");
                System.out.println(subject.getLocalName());
                
                Literal weight = solution.getLiteral("weight");
                Literal range = solution.getLiteral("range");
                Literal fireRate = solution.getLiteral("fireRate");
                Literal price = solution.getLiteral("price");
                gunList.add(new Gun(subject.getLocalName(),Double.parseDouble(weight.getString()),Integer.parseInt(range.getString()),Integer.parseInt(fireRate.getString()),Integer.parseInt(price.getString())));
            }
        } finally {
            qexec.close();
        }
        return gunList;
		
	}
	
	
public List<Gun> SortTable(int i,String col) {
		
		FileManager.get().addLocatorClassLoader(FirearmOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("fa2.owl");
        //  model.write(System.out,"TURTLE");

        List<Gun> gunList = new ArrayList<Gun>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX ex: <http://www.semanticweb.org/promod/ontologies/2019/6/firearm#> " +
                "SELECT DISTINCT ?subject ?weight ?range ?fireRate ?price " +
                "WHERE { ?subject ex:hasFunction ?bases ."+
                "?subject ex:hasWeight ?weight ."+
                "?subject ex:hasRange ?range ."+
                "?subject ex:hasFireRate ?fireRate ."+
                "?subject ex:hasPrice ?price"
                + "}";
        if(i==0) {
        	queryString += "ORDER BY ASC (?" + col+ ")";
        }else {
        	queryString += "ORDER BY DESC (?" + col+ ")";
        }
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource subject = solution.getResource("subject");
                System.out.println(subject.getLocalName());
                
                Literal weight = solution.getLiteral("weight");
                Literal range = solution.getLiteral("range");
                Literal fireRate = solution.getLiteral("fireRate");
                Literal price = solution.getLiteral("price");
                gunList.add(new Gun(subject.getLocalName(),Double.parseDouble(weight.getString()),Integer.parseInt(range.getString()),Integer.parseInt(fireRate.getString()),Integer.parseInt(price.getString())));
            }
        } finally {
            qexec.close();
        }
        return gunList;
		
	}
	public List<String> findWeaponWithAllConfig(){
		FileManager.get().addLocatorClassLoader(FirearmOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("fa2.owl");
        //  model.write(System.out,"TURTLE");

        List<String> cakeBaseList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX ex: <http://www.semanticweb.org/promod/ontologies/2019/6/firearm#> " +
                "SELECT DISTINCT ?bases " +
                "WHERE { ?subject ex:hasConfiguration ?bases}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("bases");
                System.out.println(bases.getLocalName());
                cakeBaseList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeBaseList;
	}
	
	
	public List<String> getAllFunctions(){
		FileManager.get().addLocatorClassLoader(FirearmOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("fa2.owl");
        //  model.write(System.out,"TURTLE");

        List<String> cakeBaseList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX ex: <http://www.semanticweb.org/promod/ontologies/2019/6/firearm#> " +
                "SELECT DISTINCT ?bases " +
                "WHERE { ?subject ex:hasFunction ?bases}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("bases");
                System.out.println(bases.getLocalName());
                cakeBaseList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeBaseList;
	}
	
	
	public List<String> findWeaponWithAllPurpose(){
		FileManager.get().addLocatorClassLoader(FirearmOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("fa2.owl");
        //  model.write(System.out,"TURTLE");

        List<String> cakeBaseList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX ex: <http://www.semanticweb.org/promod/ontologies/2019/6/firearm#> " +
                "SELECT DISTINCT ?bases " +
                "WHERE { ?subject ex:hasPurpose ?bases}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("bases");
                System.out.println(bases.getLocalName());
                cakeBaseList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeBaseList;
	}

	
	 public List<Gun> findGunsForGunSearch(String selectedFunction, String selectedConfiguration, String selectedPurpose,String gunType, String priceFrom, String priceTo) {

	        FileManager.get().addLocatorClassLoader(FirearmOntology.class.getClassLoader());
	        Model model = FileManager.get().loadModel("fa2.owl");
	        //  model.write(System.out,"TURTLE");

	        List<Gun> gunList = new ArrayList<Gun>();

	        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
	                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
	                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
	                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
	                "PREFIX ex: <http://www.semanticweb.org/promod/ontologies/2019/6/firearm#> " +
	                "SELECT ?subject ?weight ?range ?fireRate ?price " +
	                "WHERE { ";

	        if (!(gunType == null || gunType.isEmpty())) {
	            queryString += "?subject rdf:type ?type . "+"?type rdfs:subClassOf* ex:"+gunType+" . ";  

	        }
	        if (!(selectedFunction == null || selectedFunction.isEmpty())) {
	            queryString += "?subject ex:hasFunction ex:" + selectedFunction + ". ";  

	        }

	        if (!(selectedConfiguration == null || selectedConfiguration.isEmpty())) {
	            queryString += "?subject ex:hasConfiguration ex:" + selectedConfiguration + ". ";
	        }
	        if (!(selectedPurpose == null || selectedPurpose.isEmpty())) {
	            queryString += "?subject ex:hasPurpose ex:" + selectedPurpose + ". ";
	        }

	        if (!(priceFrom == null || priceFrom.isEmpty()) && !(priceTo == null || priceTo.isEmpty())) {
	            queryString += "?subject ex:hasPrice ?price. " +
	                    "FILTER (?price > " + priceFrom + " && ?price < " + priceTo + ") . ";
	        } else {
	            queryString += "?subject ex:hasPrice ?price . ";
	        }

	        queryString += "?subject ex:hasWeight ?weight . "+ "?subject ex:hasRange ?range . "+"?subject ex:hasFireRate ?fireRate . }";
	        System.out.println(queryString);

	        Query query = QueryFactory.create(queryString);
	        QueryExecution qexec = QueryExecutionFactory.create(query, model);

	        try {
	            ResultSet results = qexec.execSelect();
	            while (results.hasNext()) {
	                QuerySolution solution = results.nextSolution();
	                Resource subject = solution.getResource("subject");
	                Literal weight = solution.getLiteral("weight");
	                Literal range = solution.getLiteral("range");
	                Literal fireRate = solution.getLiteral("fireRate");
	                Literal price = solution.getLiteral("price");
	                gunList.add(new Gun(subject.getLocalName(),Double.parseDouble(weight.getString()),Integer.parseInt(range.getString()),Integer.parseInt(fireRate.getString()),Integer.parseInt(price.getString())));
	            }
	        } finally {
	            qexec.close();
	        }
	        return gunList;
	    }

}
