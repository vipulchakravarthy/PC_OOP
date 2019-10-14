import java.util.*;

public class User {
    String name;
    int numberOfConnections;
    User[] connections;
    User(String name, User user){
    	this.name = name;
    	this.numberOfConnections = 0;
    	connections = new User[10];
    }

    public String getUserName(){
    	return this.name;
    }

    public void addConnection(User user){
        for(int i = 0; i < numberOfConnections; i++){
            if(user.equals(connections[i])){
                return;
            }
        }
    	connections[numberOfConnections++] = user;
    }



    public User[] getConnections(){
    	User[] frnds = new User[numberOfConnections];
    	for(int i = 0; i < frnds.length;i++){
    		frnds[i] = this.connections[i];
    	}
    	return frnds;
    }

    public String toString(){
    	StringBuffer sb = new StringBuffer();
        if(this.numberOfConnections == 0){
            return this.name + " : ";
        }
    	sb.append(this.name +" : [");
    	int i;
    	for(i = 0; i < numberOfConnections-1; i++){
                sb.append(this.connections[i].getUserName() +", ");
    	}
        sb.append(this.connections[i].getUserName());
        sb.append("]");
    	return sb.toString();
    }
}
