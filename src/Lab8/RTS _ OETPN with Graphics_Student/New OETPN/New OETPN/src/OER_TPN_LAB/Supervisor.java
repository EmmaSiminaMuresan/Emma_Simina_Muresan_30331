package OER_TPN_LAB;

import java.util.ArrayList;
import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriTransition;
import Components.PetriNetWindow;
import DataObjects.DataInteger;
import DataObjects.DataTransfer;
import DataObjects.DataREL;
import DataObjects.DataRELQueue;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
import DataOnly.TransferOperation;

public class Supervisor {
    public static void main(String[] args) {
        PetriNet pn = new PetriNet();
        pn.PetriNetName = "supervisor part";
        pn.NetworkPort = 1082;

        DataREL ps_i1 = new DataREL();
        ps_i1.SetName("ps_i1");
        pn.PlaceList.add(ps_i1);

        DataRELQueue ps_1 = new DataRELQueue();
        ps_1.SetName("ps_1");
        pn.PlaceList.add(ps_1);
        ps_1.Value.Size = 10;

        DataTransfer ps_o1 = new DataTransfer();
        ps_o1.SetName("ps_o1");
        ps_o1.Value = new TransferOperation("localhost", "1080", "p_i1");
        pn.PlaceList.add(ps_o1);

        DataInteger ps_2 = new DataInteger();
        ps_2.SetName("ps_2");
        ps_2.Value = 0;
        pn.PlaceList.add(ps_2);

        DataInteger ps_3 = new DataInteger();
        ps_3.SetName("ps_3");
        ps_3.Value = 2;
        pn.PlaceList.add(ps_3);

        DataInteger ps_o2 = new DataInteger();
        ps_o2.SetName("ps_o2");
        pn.PlaceList.add(ps_o2);

        DataInteger ps_i2 = new DataInteger();
        ps_i2.SetName("ps_i2");
        pn.PlaceList.add(ps_i2);
        

        // transition 1 
        PetriTransition ts_1 = new PetriTransition(pn);
        ts_1.TransitionName = "ts_1";
        ts_1.InputPlaceName.add("ps_i1");
        ts_1.InputPlaceName.add("ps_1");
        ts_1.Delay = 0;

        Condition ts1ct1 = new Condition(ts_1, "ps_i1", TransitionCondition.NotNull);

        GuardMapping grdt1 = new GuardMapping();
        grdt1.condition = ts1ct1;
        grdt1.Activations.add(new Activation(ts_1, "ps_i1", TransitionOperation.AddElement, "ps_1"));

        ts_1.GuardMappingList.add(grdt1);
        pn.Transitions.add(ts_1);


        // Transition 2 
        ArrayList<String> output = new ArrayList<String>();
        output.add("ps_o1");
        output.add("ps_3");
        PetriTransition ts_2 = new PetriTransition(pn);
        ts_2.TransitionName = "ts_2";
        ts_2.InputPlaceName.add("ps_1");
        ts_2.InputPlaceName.add("ps_2");
        ts_2.InputPlaceName.add("ps_3");

        Condition ts2ct1 = new Condition(ts_2, "ps_1", TransitionCondition.HaveREL);
        Condition ts2ct2 = new Condition(ts_2, "ps_1", TransitionCondition.NotNull);
        Condition ts2ct3 = new Condition(ts_2, "ps_2", TransitionCondition.NotNull);

        ts2ct2.SetNextCondition(LogicConnector.AND, ts2ct3);
        ts2ct1.SetNextCondition(LogicConnector.AND, ts2ct2);

        
        GuardMapping grdts2 = new GuardMapping();
        grdts2.condition = ts2ct1;
        // grdts2.Activations.add(new Activation(ts_2, "ps_1", TransitionOperation.Move, "ps_o1"));
        grdts2.Activations.add(new Activation(ts_2, "ps_1", TransitionOperation.SendROverNetwork, "ps_o1"));
        grdts2.Activations.add(new Activation(ts_2, "ps_1", TransitionOperation.PopElement_R_E, output));


        ts_2.GuardMappingList.add(grdts2);
        ts_2.Delay = ps_3.Value;
        pn.Transitions.add(ts_2);


        // Transition 3
        PetriTransition ts_3 = new PetriTransition(pn);
        ts_3.TransitionName = "ts_3";
        ts_3.InputPlaceName.add("ps_i2");
        Condition ts3ct1 = new Condition(ts_3, "ps_i2", TransitionCondition.NotNull);
        GuardMapping grdts31 = new GuardMapping();
        grdts31.condition = ts3ct1;

        grdts31.Activations.add(new Activation(ts_3, "ps_i2", TransitionOperation.Move, "ps_2"));
        grdts31.Activations.add(new Activation(ts_3, "ps_i2", TransitionOperation.Move, "ps_o2"));
        ts_3.GuardMappingList.add(grdts31);
        ts_3.Delay = 0;
        pn.Transitions.add(ts_3);


        System.out.println("Exp1 started \n ----------------------------");
        pn.Delay = 3000;

        PetriNetWindow frame = new PetriNetWindow(false);
        frame.petriNet = pn;
        frame.setVisible(true);
    }
}
