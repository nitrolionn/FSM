public class Main {

	public static void main(String[] args) {

		FSM fsm = new FSM();
		fsm.handleState(State.A);
		fsm.handleState(State.C);
		fsm.handleState(State.C);
		fsm.handleState(State.C);
		fsm.handleState(State.D);
		fsm.handleState(State.D);
		System.out.println();
		fsm = new FSM();
		fsm.handleState(State.E);
		fsm.handleState(State.E);
		fsm.handleState(State.E);
		System.out.println();
		fsm = new FSM();
		fsm.handleState(State.A);
		fsm.handleState(State.A);

	}
}

enum State {
	A {
		@Override
		public State handle(State s) {
			System.out.println("A -> B");
			return B;
		}
	},

	B {
		@Override
		public State handle(State s) {
			if (s == C) {
				System.out.println("B -> C");
				return C;
			} else if (s == D) {
				System.out.println("B -> D");
				return D;
			} else if (s == E) {
				System.out.println("B -> E");
				return E;
			} else {
				System.out.println("Wrong state.");
				return null;
			}
		}
	},

	C {
		@Override
		public State handle(State s) {
			System.out.println("C -> A");
			return A;
		}
	},
	D {
		@Override
		public State handle(State s) {
			System.out.println("D stop");
			return null;
		}
	},
	E {
		@Override
		public State handle(State s) {
			System.out.println("E stop");
			return null;
		}
	};

	public abstract State handle(State s);
}
class FSM {

	private State state;

	public FSM() {
		this.state = State.A;
	}

	public void handleState(State s) {
		State handledState = state.handle(s);
		if (handledState != null) {
			state = handledState;
		}
	}
}