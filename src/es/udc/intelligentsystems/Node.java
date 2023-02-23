package es.udc.intelligentsystems;

public class Node extends State{
    Node father;
    State state;//revisar y definir correctamente
    int peso;

    public Node(Node nd) {
        this.father = nd.father;
        this.peso = nd.peso;
        this.state = nd.state;
    }

    public Node(Node father, State state, int peso) {
        this.father = father;
        this.state = state;
        this.peso = peso;
    }

    public Node (State state){
        this.state = state;
    }

    public Node getFather() {
        return father;
    }

    public State getState() {
        return state;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return state.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if (obj.getClass()==this.getClass()){
            Node nd = new Node((Node)obj);
            if(nd.father==this.father&&nd.state==this.state&&nd.peso==this.peso) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {//pendiente hash
        return 0;
    }
}
