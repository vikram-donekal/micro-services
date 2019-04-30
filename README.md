
prerequisites:

Docker - container 
K8s - Container Orchestrator
Helm - Package Manager
Minikube - Simple K8s Testing Purpose orchestrator


	TechStack:
	1: Java Spring Boot
	2: Rest API
	3: Spring JPA (Postgresql)
	4: Spring Cache (InMemory)
	5: Docker 
	6: K8s
	7: Helm
	
	

 I have wrriten two micro-services which will interact with Postgresql (DataBase) and providing InMemory - Cache Mechanism for REST API.
 
      
	  
	  USER REQUEST 
	      |  
	      |
	      |
		  |
		  <>
	------------------------------------------------------------------------------------------------------------------------- (Minikube)	  
		 INGRESS  Controller
		    Path:
			   /m1:Micro-service-1 (Service)
			   /m2:Micro-service-2 (Service)
			   


			   
			   

        Micro-service -1                                       Micro-service-2 
           
		 
	  REST API  ------------- <>  Cache InMemory                  	  REST API  ------------- <>  Cache InMemory
           |                                                            |
           | 															|
		   |															|	
		   |															|
		   |															<>
	      <>                                                          DataBase
		DataBase													   (Postgresql)
        (Postgresql)	
  ---------------------------------------------------------------------------------------------------------------------------------


	
	Steps to Deploy:
	
	1: Using Helm Chart:
	      
		 * I have created 3 helm Charts 
		         2 (Micro-service)
				 1 (Postgresql)
				
		Go to File Locations:		
		
		Command:  helm install postgresql-3.16.1.tgz -n postgresql
		Command:  helm install micro-service-1-0.1.0.tgz -n m1
		Command:  helm install micro-service-2-0.1.0.tgz -n m2
	     
		 
		Verify by:
           Command: kubectl get pods
		      Check micro-services pods UP and Running
			Command: kubectl get services
			   Check Micro-service services is Cluster-IP
		
	2: Enable Ingress in Minikube:
	   https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/
	   
	   Command : minikube addons enable ingress
	    
		Go to yaml File Location : ingress.yaml
		Command: kubectl create -f ingress.yaml
		
	
	Test:

	test -1 : 	curl http://<machine-ip>:80/student/api/student/find/all
				Reponse : we will get a list of students (Reponse may take time as it may contains randam number of records)
		
	test -2 : curl http://<machine-ip>:80/student/api/student/find/{id}
	           
			   Reponse: It will return a record if Present (First Time it will hit DataBase)
							(Next Time if we do same Curl Operation it will return from InMemory Cache)
	
	
	Swagger API -Documentation:	
	
	:Run SpringBoot Jar: (Inside Targer folder of m1/m2 Folders)
	
		java -jar nokia-micro-serivice-1-0.0.1-SNAPSHOT.jar or  java -jar nokia-micro-serivice-2-0.0.1-SNAPSHOT.jar 
		
		java -jar nokia-micro-serivice-1:
			port : 9090
			Swagger URL : localhost:9090/swagger-ui.html
			
		java -jar nokia-micro-serivice-2:
			port : 9091
			Swagger URL : localhost:9091/swagger-ui.html
			
		
		
		
		
		
		
        
		
			

		
	 
	
		   