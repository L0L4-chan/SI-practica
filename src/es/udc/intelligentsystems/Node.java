package es.udc.intelligentsystems;

public class Node extends State{
    Node father;
    private final State state;//revisar y definir correctamente


    public Node(Node nd) {
        this.father = nd.father;
        this.state = nd.state;
    }

    public Node(Node father, State state) {
        this.father = father;
        this.state = state;

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


    @Override
    public String toString() {
        return state.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }else if (obj.getClass() == this.getClass()) {
            Node nd = new Node((Node) obj);

            return nd.state == this.state;

        }
        return false;
    }

    @Override
    public int hashCode() {//pendiente hash
        return 0;
    }
}
