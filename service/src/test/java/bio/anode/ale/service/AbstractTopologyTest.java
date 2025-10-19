package bio.anode.ale.service;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import bio.anode.ale.core.component.fluidic.Chamber;
import bio.anode.ale.core.component.fluidic.Evacuation;
import bio.anode.ale.core.component.fluidic.Intake;
import bio.anode.ale.core.component.fluidic.Junction;
import bio.anode.ale.core.component.fluidic.Trap;
import bio.anode.ale.core.component.fluidic.valve.Diverter;
import bio.anode.ale.core.component.fluidic.valve.NormallyClosedValve;
import bio.anode.ale.core.component.fluidic.valve.NormallyOpenedValve;
import bio.anode.ale.core.component.fluidic.valve.SolenoidValve;
import bio.anode.ale.core.usage.ComponentUsage;
import bio.anode.ale.core.usage.fluidic.ChamberUsage;
import bio.anode.ale.core.usage.fluidic.EvacuationUsage;
import bio.anode.ale.core.usage.fluidic.FluidicComponantUsage;
import bio.anode.ale.core.usage.fluidic.IntakeUsage;
import bio.anode.ale.core.usage.fluidic.JunctionUsage;
import bio.anode.ale.core.usage.fluidic.TrapUsage;
import bio.anode.ale.core.usage.fluidic.valve.DiverterUsage;
import bio.anode.ale.core.usage.fluidic.valve.ValveUsage;

public interface AbstractTopologyTest {

    default List<ChamberUsage> generatedChamberUsages(){
        List<ChamberUsage> result = new ArrayList<>();
        Chamber chambre1 = new Chamber(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Chamber.class),"794",2, 16.0);
        ChamberUsage chambreUsage1 = new ChamberUsage(UUID.fromString("0197a0fd-a6da-7c24-83ff-ecaadd2a3f14"), chambre1,"Chamber 1", new Point(85, 535),1,14.745, 80.0 );
        result.add(chambreUsage1);

        Chamber chambre2 = new Chamber(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Chamber.class),"794",2, 16.0);
        ChamberUsage chambreUsage2 = new ChamberUsage(UUID.fromString("0197a102-331a-7a7c-a617-9116746d5e59"), chambre2,"Chamber 2", new Point(85, 535),1,14.745, 80.0 );
        result.add(chambreUsage2);

        Chamber chambre3 = new Chamber(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Chamber.class),"794",2, 16.0);
        ChamberUsage chambreUsage3 = new ChamberUsage(UUID.fromString("0197a10d-8e20-7361-bf74-135732905fc7"), chambre3,"Chamber 3", new Point(85, 535),1,14.745, 80.0 );
        result.add(chambreUsage3);

        Chamber chambre4 = new Chamber(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Chamber.class),"794",2, 16.0);
        ChamberUsage chambreUsage4 = new ChamberUsage(UUID.fromString("0197a10a-6f97-7b94-80d3-4860392b24a0"), chambre4,"Chamber 4", new Point(85, 535),1,14.745, 80.0 );
        result.add(chambreUsage4);

        return result;
    }

    default List<TrapUsage>  generatedTrapUsages(){
        List<TrapUsage> result = new ArrayList<>();

        Trap trap1 = new Trap(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Trap.class), "0", 2);
        TrapUsage trapUsage1 = new TrapUsage(UUID.fromString("0197a104-94fa-7735-af33-19aeccb080a0"), trap1, "Trap", new Point(490,695));
        result.add(trapUsage1);

        Trap trap2 = new Trap(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Trap.class), "0", -1);
        TrapUsage trapUsage2 = new TrapUsage(UUID.fromString("0197a119-f7aa-76df-8a18-39f46009f873"), trap2, "Trap", new Point(740,695));
        result.add(trapUsage2);

        return result;

    }

    default List<JunctionUsage> generatedJunctionUsages(){
        List<JunctionUsage> result = new ArrayList<>();

        Junction junction1 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", 2);
        JunctionUsage junctionUsage1 = new JunctionUsage(UUID.fromString("0197a100-5979-7359-b59c-f441b3a7c50b"), junction1, "T", new Point(70, 700), 8);
        result.add(junctionUsage1);

        Junction junction2 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", 2);
        JunctionUsage junctionUsage2 = new JunctionUsage(UUID.fromString("0197a100-d222-7827-91a6-ef4a54e6e676"), junction2, "T", new Point(100, 505), 8);
        result.add(junctionUsage2);

        Junction junction3 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", 2);
        JunctionUsage junctionUsage3 = new JunctionUsage(UUID.fromString("0197a100-ff97-7b29-b3ff-da9b1be26cd3"), junction3, "T", new Point(125, 615), 1);
        result.add(junctionUsage3);

        Junction junction4 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", 2);
        JunctionUsage junctionUsage4 = new JunctionUsage(UUID.fromString("0197a101-9e20-773e-86dd-21806629e1c1"), junction4, "T", new Point(115, 440), 1);
        result.add(junctionUsage4);

        Junction junction5 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", 2);
        JunctionUsage junctionUsage5 = new JunctionUsage(UUID.fromString("0197a102-ba6c-7b77-ba05-75eb9125e33c"), junction5, "T", new Point(260, 700), 8);
        result.add(junctionUsage5);

        Junction junction6 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", 2);
        JunctionUsage junctionUsage6 = new JunctionUsage(UUID.fromString("0197a102-ee2c-7bd7-81d1-959b5b0add2c"), junction6, "T", new Point(315, 615), 1);
        result.add(junctionUsage6);

        Junction junction7 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", 2);
        JunctionUsage junctionUsage7 = new JunctionUsage(UUID.fromString("0197a103-4c26-7cba-b711-3eb765a08041"), junction7, "T", new Point(305, 440), 1);
        result.add(junctionUsage7);

        Junction junction8 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", 2);
        JunctionUsage junctionUsage8 = new JunctionUsage(UUID.fromString("0197a103-b9af-7711-b374-612dfc263179"), junction8, "T", new Point(290, 505), 8);
        result.add(junctionUsage8);
        
        Junction junction9 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", 2);
        JunctionUsage junctionUsage9 = new JunctionUsage(UUID.fromString("0197a104-6cae-75ac-943b-dfd2d53b2ba3"), junction9, "T", new Point(165, 710), 4);
        result.add(junctionUsage9);

        Junction junction10 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage10 = new JunctionUsage(UUID.fromString("0197a107-4d9e-7d9b-87eb-37238e02b8cf"), junction10, "T", new Point(915, 440), 1);
        result.add(junctionUsage10);

        Junction junction11 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage11 = new JunctionUsage(UUID.fromString("0197a10a-989e-7e39-8caf-3a407ef2531c"), junction11, "T", new Point(965, 710), 4);
        result.add(junctionUsage11);

        Junction junction12 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage12 = new JunctionUsage(UUID.fromString("0197a10b-f5a3-7117-9a03-8c9c4250e2ce"), junction12, "T", new Point(900, 505), 8);
        result.add(junctionUsage12);

        Junction junction13 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage13 = new JunctionUsage(UUID.fromString("0197a10c-5f0e-7f93-8238-41f5cf8f3ae1"), junction13, "T", new Point(870, 700), 8);
        result.add(junctionUsage13);

        Junction junction14 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage14 = new JunctionUsage(UUID.fromString("0197a10c-ca66-7968-b6cb-39502b3b31a3"), junction14, "T", new Point(1095, 505), 8);
        result.add(junctionUsage14);

        Junction junction15 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage15 = new JunctionUsage(UUID.fromString("0197a10c-f4bf-7d42-8456-cad529b62c45"), junction15, "T", new Point(1110, 440), 1);
        result.add(junctionUsage15);

        Junction junction16 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage16 = new JunctionUsage(UUID.fromString("0197a10d-b4b5-713e-97ec-7a7e4658517e"), junction16, "T", new Point(1120, 615), 1);
        result.add(junctionUsage16);

        Junction junction17 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage17 = new JunctionUsage(UUID.fromString("0197a10d-dd31-76fa-af1b-24d0815918fb"), junction17, "T", new Point(1065, 700), 8);
        result.add(junctionUsage17);

        Junction junction18 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage18 = new JunctionUsage(UUID.fromString("0197a10e-3288-76e1-9ffd-82ea679a8e41"), junction18, "T", new Point(925, 615), 1);
        result.add(junctionUsage18);

        Junction junction19 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage19 = new JunctionUsage(UUID.fromString("0197a10f-3f08-7b80-b125-896596bf7035"), junction19, "T", new Point(1015, 430), 1);
        result.add(junctionUsage19);

        Junction junction20 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage20 = new JunctionUsage(UUID.fromString("0197a10f-6299-7dc7-aa4b-5fe4d9c2a7a4"), junction20, "T", new Point(205, 430), 1);
        result.add(junctionUsage20);

        Junction junction21 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage21 = new JunctionUsage(UUID.fromString("0197a10f-b1bc-7db5-941e-cd1c643dbff9"), junction21, "T", new Point(455, 690), 16);
        result.add(junctionUsage21);

        Junction junction22 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage22 = new JunctionUsage(UUID.fromString("0197a10f-f598-75c2-af9a-3de61ebe2298"), junction22, "T", new Point(395, 25), 16);
        result.add(junctionUsage22);

        Junction junction23 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage23 = new JunctionUsage(UUID.fromString("0197a110-67cc-760d-b1d1-7e9708190d64"), junction23, "T", new Point(605, 60), 4);
        result.add(junctionUsage23);

        Junction junction24 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage24 = new JunctionUsage(UUID.fromString("0197a110-8ff7-7b6c-81f5-1d34451de0f9"), junction24, "T", new Point(395, 60), 16);
        result.add(junctionUsage24);

        Junction junction25 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage25 = new JunctionUsage(UUID.fromString("0197a110-bb50-7cbe-a3e5-48fc1d13b41d"), junction25, "T", new Point(395, 160), 16);
        result.add(junctionUsage25);

        Junction junction26 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage26 = new JunctionUsage(UUID.fromString("0197a110-e397-75e5-8a46-e7b82d828029"), junction26, "T", new Point(395, 265), 16);
        result.add(junctionUsage26);

        Junction junction27 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage27 = new JunctionUsage(UUID.fromString("0197a111-07d4-797d-b3f8-440bb4314c78"), junction27, "T", new Point(395, 355), 16);
        result.add(junctionUsage27);

        Junction junction28 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage28 = new JunctionUsage(UUID.fromString("0197a112-1ac9-7839-a9c8-a58bb01fdb8b"), junction28, "T", new Point(605, 160), 4);
        result.add(junctionUsage28);

        Junction junction29 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage29 = new JunctionUsage(UUID.fromString("0197a112-4639-7027-9da3-3caa870a4d20"), junction29, "T", new Point(490, 160), 1);
        result.add(junctionUsage29);

        Junction junction30 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage30 = new JunctionUsage(UUID.fromString("0197a112-6d0c-79a9-8e31-86fd29cbfd01"), junction30, "T", new Point(720, 160), 1);
        result.add(junctionUsage30);

        Junction junction31 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage31 = new JunctionUsage(UUID.fromString("0197a113-cf4b-7c2c-b68e-ab71f0b3d3bb"), junction31, "T", new Point(720, 265), 1);
        result.add(junctionUsage31);

        Junction junction32 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage32 = new JunctionUsage(UUID.fromString("0197a115-7ad9-79c7-816e-27ab1213211c"), junction32, "T", new Point(490, 265), 1);
        result.add(junctionUsage32);

        Junction junction33 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage33 = new JunctionUsage(UUID.fromString("0197a115-9de1-77cc-86e3-140672e49381"), junction33, "T", new Point(605, 265), 4);
        result.add(junctionUsage33);

        Junction junction34 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage34 = new JunctionUsage(UUID.fromString("0197a116-1ded-7ef4-8706-97940ea78441"), junction34, "T", new Point(605, 355), 4);
        result.add(junctionUsage34);

        Junction junction35 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage35 = new JunctionUsage(UUID.fromString("0197a116-3dde-7f4a-9cd5-518a7d662ea3"), junction35, "T", new Point(815, 60), 8);
        result.add(junctionUsage35);

        Junction junction36 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage36 = new JunctionUsage(UUID.fromString("0197a116-5fe8-7de7-9463-8102fb8a64e9"), junction36, "T", new Point(815, 160), 8);
        result.add(junctionUsage36);

        Junction junction37 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage37 = new JunctionUsage(UUID.fromString("0197a116-810e-746e-b623-7db255d60210"), junction37, "T", new Point(815, 265), 8);
        result.add(junctionUsage37);

        Junction junction38 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage38 = new JunctionUsage(UUID.fromString("0197a116-cfdc-7d3e-9a8d-c3dd576cf566"), junction38, "T", new Point(815, 25), 8);
        result.add(junctionUsage38);

        Junction junction39 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage39 = new JunctionUsage(UUID.fromString("0197a117-9e88-7e94-838f-80be330d07a2"), junction39, "T", new Point(815, 355), 8);
        result.add(junctionUsage39);

        Junction junction40 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage40 = new JunctionUsage(UUID.fromString("0197a118-1eb1-766d-adbd-5235b3d2098e"), junction40, "T", new Point(395, 420), 1);
        result.add(junctionUsage40);

        Junction junction41 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage41 = new JunctionUsage(UUID.fromString("0197a118-eacf-7e74-8211-bf2e72ebd0a6"), junction41, "T", new Point(815, 420), 1);
        result.add(junctionUsage41);

        Junction junction42 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage42 = new JunctionUsage(UUID.fromString("0197a11a-6cb8-73e8-bee7-e26c99b36c43"), junction42, "T", new Point(755, 690), 8);
        result.add(junctionUsage42);

        Junction junction43 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage43 = new JunctionUsage(UUID.fromString("0197a11c-6343-7fdb-889e-78bf57e7ec69"), junction43, "T", new Point(315, 15), 1);
        result.add(junctionUsage43);

        Junction junction44 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage44 = new JunctionUsage(UUID.fromString("0197a11c-ce53-70ae-a0b7-abfdd43eefe9"), junction44, "T", new Point(890, 15), 1);
        result.add(junctionUsage44);

        Junction junction45 = new Junction(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Junction.class), "0", -1);
        JunctionUsage junctionUsage45 = new JunctionUsage(UUID.fromString("0197a11c-f758-7c23-9d9a-a94333787610"), junction45, "T", new Point(605, -20), 1);
        result.add(junctionUsage45);

        return result;
    }

    default List<EvacuationUsage> generatedEvacuationUsages(){
        List<EvacuationUsage> result = new ArrayList<>();

        Evacuation evacuation1 = new Evacuation(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Evacuation.class), "0", 2);
        EvacuationUsage evacuationUsage1 = new EvacuationUsage(UUID.fromString("0197a102-023f-7add-87c0-10d51ae04971"), evacuation1, "WASTE", new Point(25,505));
        result.add(evacuationUsage1);

        Evacuation evacuation2 = new Evacuation(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Evacuation.class), "0", 2);
        EvacuationUsage evacuationUsage2 = new EvacuationUsage(UUID.fromString("0197a104-1c98-7db5-95a5-3aa23bf01668"), evacuation2, "WASTE", new Point(215,505));
        result.add(evacuationUsage2);


        Evacuation evacuation3 = new Evacuation(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Evacuation.class), "0", 2);
        EvacuationUsage evacuationUsage3 = new EvacuationUsage(UUID.fromString("0197a10d-3f29-7b3b-8b8d-ab4e85f7a0f3"), evacuation3, "WASTE", new Point(1020,505));
        result.add(evacuationUsage3);

        Evacuation evacuation4 = new Evacuation(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Evacuation.class), "0", 2);
        EvacuationUsage evacuationUsage4 = new EvacuationUsage(UUID.fromString("0197a10e-9649-74e2-97f4-375ff72b8597"), evacuation4, "WASTE", new Point(825,505));
        result.add(evacuationUsage4);

        Evacuation evacuation5 = new Evacuation(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Evacuation.class), "0", 2);
        EvacuationUsage evacuationUsage5 = new EvacuationUsage(UUID.fromString("0197a119-8730-73f9-8d6a-d2114c0bc084"), evacuation5, "WASTE", new Point(575,505));
        result.add(evacuationUsage5);

        Evacuation evacuation6 = new Evacuation(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Evacuation.class), "0", 2);
        EvacuationUsage evacuationUsage6 = new EvacuationUsage(UUID.fromString("0197a119-ade7-7018-b0f7-83282379c263"), evacuation6, "WASTE", new Point(615,505));
        result.add(evacuationUsage6);


        Evacuation evacuation7 = new Evacuation(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Evacuation.class), "0", 2);
        EvacuationUsage evacuationUsage7 = new EvacuationUsage(UUID.fromString("0197a11d-4829-7d43-96f7-3cba0e770b54"), evacuation7, "WASTE", new Point(545,505));
        result.add(evacuationUsage7);

        Evacuation evacuation8 = new Evacuation(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Evacuation.class), "0", 2);
        EvacuationUsage evacuationUsage8 = new EvacuationUsage(UUID.fromString("0197a11d-7015-77fe-bf14-c50bc4e078f4"), evacuation8, "WASTE", new Point(650,505));
        result.add(evacuationUsage8);

        return result;
    }

    default List<ValveUsage> generatedValveUsages(){
        List<ValveUsage> result = new ArrayList<>();
        SolenoidValve vanne1 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "800", 2);
        ValveUsage valveUsage1 = new ValveUsage(UUID.fromString("0197a0fe-0ec4-70b9-bf87-9196a7898c31"), vanne1, "O1111", "2-2-6", false, new Point(60, 505));
        result.add(valveUsage1);

        SolenoidValve vanne2 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "802", 2);
        ValveUsage valveUsage2 = new ValveUsage(UUID.fromString("0197a0fe-71b6-75ce-9ee3-4037afc89ecf"), vanne2, "X1113", "2-3-0", false, new Point(125, 550));
        result.add(valveUsage2);

        SolenoidValve vanne3 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "804", 2);
        ValveUsage valveUsage3 = new ValveUsage(UUID.fromString("0197a0ff-373a-7f8d-8cd7-b576e2456322"), vanne3, "X1112", "2-2-7", false, new Point(100, 470));
        result.add(valveUsage3);
        
        SolenoidValve vanne4 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "806", 2);
        ValveUsage valveUsage4 = new ValveUsage(UUID.fromString("0197a0ff-6589-71bb-9b62-ef3e63f9afca"), vanne4, "X1114", "2-3-1", false, new Point(40, 625));
        result.add(valveUsage4);

        SolenoidValve vanne5 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "808", 2);
        ValveUsage valveUsage5 = new ValveUsage(UUID.fromString("0197a0ff-a7df-7a94-8274-8ccc2b42ca8b"), vanne5, "X1115", "2-3-2", false, new Point(70, 670));
        result.add(valveUsage5);

        SolenoidValve vanne6 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "832", 2);
        ValveUsage valveUsage6 = new ValveUsage(UUID.fromString("0197a102-5dc1-716a-90cd-9cf23a214184"), vanne6, "X1123", "2-2-1", false, new Point(315, 550));
        result.add(valveUsage6);

        SolenoidValve vanne7 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "834", 2);
        ValveUsage valveUsage7 = new ValveUsage(UUID.fromString("0197a102-8e2d-7856-9149-6ab21bea3d54"), vanne7, "O1121", "2-1-7", false, new Point(250, 505));
        result.add(valveUsage7);

        SolenoidValve vanne8 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "844", 2);
        ValveUsage valveUsage8 = new ValveUsage(UUID.fromString("0197a103-7a5c-7b34-ab4b-4a677813f855"), vanne8, "X1125", "2-1-6", false, new Point(260, 670));
        result.add(valveUsage8);

        SolenoidValve vanne9 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "848", 2);
        ValveUsage valveUsage9 = new ValveUsage(UUID.fromString("0197a103-db4f-7b4f-a33d-bcd28660fecf"), vanne9, "X1122", "2-2-0", false, new Point(290, 470));
        result.add(valveUsage9);

        SolenoidValve vanne10 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "852", 2);
        ValveUsage valveUsage10 = new ValveUsage(UUID.fromString("0197a104-41d4-7c0a-b7ff-08f61c9f02c1"), vanne10, "X1124", "2-2-2", false, new Point(230, 625));
        result.add(valveUsage10);

        SolenoidValve vanne11 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "942", -1);
        ValveUsage valveUsage11 = new ValveUsage(UUID.fromString("0197a104-d3b4-7906-a038-8a6aae4f3afe"), vanne11, "O1126", "2-2-3", false, new Point(345, 615));
        result.add(valveUsage11);

        SolenoidValve vanne12 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "944", -1);
        ValveUsage valveUsage12 = new ValveUsage(UUID.fromString("0197a107-1df9-793d-89cd-ab2936999179"), vanne12, "O1116", "2-2-5", false, new Point(155, 615));
        result.add(valveUsage12);

        SolenoidValve vanne13 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "948", -1);
        ValveUsage valveUsage13 = new ValveUsage(UUID.fromString("0197a107-c8b9-78d8-b051-99e91e51b582"), vanne13, "X2145", "1-0-4", false, new Point(1065, 670));
        result.add(valveUsage13);

        SolenoidValve vanne14 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "950", -1);
        ValveUsage valveUsage14 = new ValveUsage(UUID.fromString("0197a108-179f-78a8-a168-d8b112b2795f"), vanne14, "O2141", "1-0-5", false, new Point(1055, 505));
        result.add(valveUsage14);

        SolenoidValve vanne15 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "952", -1);
        ValveUsage valveUsage15 = new ValveUsage(UUID.fromString("0197a108-47f0-7946-80ad-6d8e03e1cc0e"), vanne15, "O2136", "1-1-3", false, new Point(955, 615));
        result.add(valveUsage15);

        SolenoidValve vanne16 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "954", -1);
        ValveUsage valveUsage16 = new ValveUsage(UUID.fromString("0197a108-71e0-75f2-87f4-31824451b422"), vanne16, "O2146", "1-1-1", false, new Point(1150, 615));
        result.add(valveUsage16);

        SolenoidValve vanne17 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "958", -1);
        ValveUsage valveUsage17 = new ValveUsage(UUID.fromString("0197a10a-17a9-7fc4-95d4-aa4a96891418"), vanne17, "X2135", "1-2-0", false, new Point(870, 670));
        result.add(valveUsage17);

        SolenoidValve vanne18 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "960", -1);
        ValveUsage valveUsage18 = new ValveUsage(UUID.fromString("0197a115-2098-79c8-8e70-63cddbf25a30"), vanne18, "O2131", "1-1-4", false, new Point(860, 505));
        result.add(valveUsage18);

        SolenoidValve vanne19 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "970", -1);
        ValveUsage valveUsage19 = new ValveUsage(UUID.fromString("0197a10b-8c96-73df-b56b-1bb5aa9c973c"), vanne19, "X2143", "1-0-7", false, new Point(1120, 550));
        result.add(valveUsage19);

        SolenoidValve vanne20 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "972", -1);
        ValveUsage valveUsage20 = new ValveUsage(UUID.fromString("0197a10b-cd28-77c1-9bfc-8b41544b5f29"), vanne20, "X2132", "1-1-5", false, new Point(900, 470));
        result.add(valveUsage20);

        SolenoidValve vanne21 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "984", -1);
        ValveUsage valveUsage21 = new ValveUsage(UUID.fromString("0197a10c-a367-74f1-aebc-143944b34d7a"), vanne21, "X2133", "1-1-6", false, new Point(925, 550));
        result.add(valveUsage21);

        SolenoidValve vanne22 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "990", -1);
        ValveUsage valveUsage22 = new ValveUsage(UUID.fromString("0197a10d-1647-7079-b1ba-77dead06e8b2"), vanne22, "X2144", "1-1-0", false, new Point(1035, 625));
        result.add(valveUsage22);

        SolenoidValve vanne23 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "1010", -1);
        ValveUsage valveUsage23 = new ValveUsage(UUID.fromString("0197a10e-07d8-7a9c-a06e-63237f7409a4"), vanne23, "X2142", "1-0-6", false, new Point(1095, 470));
        result.add(valveUsage23);

        SolenoidValve vanne24 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "1020", -1);
        ValveUsage valveUsage24 = new ValveUsage(UUID.fromString("0197a10e-f87b-7d64-b977-cb58b8fe309d"), vanne24, "X2134", "1-1-7", false, new Point(840, 625));
        result.add(valveUsage24);

        SolenoidValve vanne25 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "870", 2);
        ValveUsage valveUsage25 = new ValveUsage(UUID.fromString("0197a10f-1d3a-772e-bdb3-34d92193b252"), vanne25, "X1006", "2-2-4", false, new Point(165, 740));
        result.add(valveUsage25);

        SolenoidValve vanne26 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10451", -1);
        ValveUsage valveUsage26 = new ValveUsage(UUID.fromString("0197a10f-8bfe-7782-ba5f-902cfa77014c"), vanne26, "X2006", "1-1-2", false, new Point(965, 740));
        result.add(valveUsage26);

        SolenoidValve vanne27 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10457", -1);
        ValveUsage valveUsage27 = new ValveUsage(UUID.fromString("0197a10f-d32b-79b5-a75b-6589d9463751"), vanne27, "X1000", "2-0-3", false, new Point(345, 15));
        result.add(valveUsage27);

        SolenoidValve vanne28 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10465", -1);
        ValveUsage valveUsage28 = new ValveUsage(UUID.fromString("0197a110-17f8-78dc-a34e-86fb3f30a701"), vanne28, "X0", "1-3-3", false, new Point(605, 25));
        result.add(valveUsage28);

        SolenoidValve vanne29 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10481", -1);
        ValveUsage valveUsage29 = new ValveUsage(UUID.fromString("0197a111-3622-7956-bad1-4f091e767ca2"), vanne29, "X1002", "2-1-0", false, new Point(435, 60));
        result.add(valveUsage29);

        SolenoidValve vanne30 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10483", -1);
        ValveUsage valveUsage30 = new ValveUsage(UUID.fromString("0197a111-57dd-7677-ae14-79145500f3f4"), vanne30, "X2002", "1-2-2", false, new Point(765, 60));
        result.add(valveUsage30);

        SolenoidValve vanne31 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10501", -1);
        ValveUsage valveUsage31 = new ValveUsage(UUID.fromString("0197a112-8f14-7ca7-a6dc-725f99bc5356"), vanne31, "O1211", "2-0-4", false, new Point(545, 160));
        result.add(valveUsage31);

        SolenoidValve vanne32 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10503", -1);
        ValveUsage valveUsage32 = new ValveUsage(UUID.fromString("0197a112-b83e-76a3-bd53-57983a9db38c"), vanne32, "O2211", "1-3-0", false, new Point(655, 160));
        result.add(valveUsage32);

        SolenoidValve vanne33 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10505", -1);
        ValveUsage valveUsage33 = new ValveUsage(UUID.fromString("0197a112-da49-758a-b762-3e8da4f3185e"), vanne33, "X2210", "1-2-3", false, new Point(765, 160));
        result.add(valveUsage33);

        SolenoidValve vanne34 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10507", -1);
        ValveUsage valveUsage34 = new ValveUsage(UUID.fromString("0197a113-0467-7eed-9b76-2da2a0331976"), vanne34, "X1210", "2-1-1", false, new Point(435, 160));
        result.add(valveUsage34);

        SolenoidValve vanne35 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10509", -1);
        ValveUsage valveUsage35 = new ValveUsage(UUID.fromString("0197a113-2ba8-75a2-9dca-535b6f885bf0"), vanne35, "O1221", "2-0-5", false, new Point(545, 265));
        result.add(valveUsage35);

        SolenoidValve vanne36 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10511", -1);
        ValveUsage valveUsage36 = new ValveUsage(UUID.fromString("0197a113-4d56-7e04-8443-0f70ac2b34a6"), vanne36, "X1220", "2-1-2", false, new Point(435, 265));
        result.add(valveUsage36);

        SolenoidValve vanne37 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10515", -1);
        ValveUsage valveUsage37 = new ValveUsage(UUID.fromString("0197a113-a913-79ed-b111-b039081c384d"), vanne37, "O2221", "1-3-1", false, new Point(655, 265));
        result.add(valveUsage37);

        SolenoidValve vanne38 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10519", -1);
        ValveUsage valveUsage38 = new ValveUsage(UUID.fromString("0197a115-4f48-77df-ad24-683d89136558"), vanne38, "X2220", "1-2-4", false, new Point(765, 265));
        result.add(valveUsage38);

        SolenoidValve vanne39 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10527", -1);
        ValveUsage valveUsage39 = new ValveUsage(UUID.fromString("0197a115-d2c9-77f2-975f-e6695e9a1418"), vanne39, "X1003", "2-1-3", false, new Point(435, 355));
        result.add(valveUsage39);

        SolenoidValve vanne40 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10535", -1);
        ValveUsage valveUsage40 = new ValveUsage(UUID.fromString("0197a115-f60e-7de2-aaf7-01d3541a092b"), vanne40, "X2003", "1-2-5", false, new Point(765, 355));
        result.add(valveUsage40);

        SolenoidValve vanne41 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10559", -1);
        ValveUsage valveUsage41 = new ValveUsage(UUID.fromString("0197a117-f4ca-7791-b8a8-f07d78374ea5"), vanne41, "X2000", "1-0-3", false, new Point(850, 15));
        result.add(valveUsage41);

        SolenoidValve vanne42 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10567", -1);
        ValveUsage valveUsage42 = new ValveUsage(UUID.fromString("0197a118-56ea-706c-8e8e-f3d7afb8ae58"), vanne42, "O1005", "2-1-4", false, new Point(440, 420));
        result.add(valveUsage42);
        
        SolenoidValve vanne43 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10569", -1);
        ValveUsage valveUsage43 = new ValveUsage(UUID.fromString("0197a118-95c7-7990-ae00-cd29919bbde8"), vanne43, "X1004", "2-1-5", false, new Point(350, 420));
        result.add(valveUsage43);

        SolenoidValve vanne44 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10571", -1);
        ValveUsage valveUsage44 = new ValveUsage(UUID.fromString("0197a118-bdaa-7ea2-a93c-8eaf73727aac"), vanne44, "X2004", "1-2-1", false, new Point(850, 420));
        result.add(valveUsage44);

        SolenoidValve vanne45 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10575", -1);
        ValveUsage valveUsage45 = new ValveUsage(UUID.fromString("0197a119-12b4-73b3-b4ab-4a5acdcbf480"), vanne45, "O2005", "1-2-6", false, new Point(770, 420));
        result.add(valveUsage45);

        SolenoidValve vanne46 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10577", -1);
        ValveUsage valveUsage46 = new ValveUsage(UUID.fromString("0197a119-3979-785f-abd0-f503e0599a22"), vanne46, "O1007", "2-0-7", false, new Point(455, 740));
        result.add(valveUsage46);

        SolenoidValve vanne47 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10579", -1);
        ValveUsage valveUsage47 = new ValveUsage(UUID.fromString("0197a119-5d4c-7a7c-9776-b4f19148106c"), vanne47, "O1008", "2-0-6", false, new Point(510, 690));
        result.add(valveUsage47);

        SolenoidValve vanne48 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10587", -1);
        ValveUsage valveUsage48 = new ValveUsage(UUID.fromString("0197a119-d215-7ddf-8536-3d2410759d40"), vanne48, "O2007", "1-2-7", false, new Point(755, 740));
        result.add(valveUsage48);

        SolenoidValve vanne49 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10591", -1);
        ValveUsage valveUsage49 = new ValveUsage(UUID.fromString("0197a11a-1c02-717c-8b07-20bd42229945"), vanne49, "O2008", "1-3-2", false, new Point(690, 690));
        result.add(valveUsage49);

        SolenoidValve vanne50 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "10965", -1);
        ValveUsage valveUsage50 = new ValveUsage(UUID.fromString("0197a11b-219c-7c79-bb57-f2c2cb56e5c8"), vanne50, "X2", "1-3-4", false, new Point(605, 85));
        result.add(valveUsage50);

        SolenoidValve vanne51 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10967", -1);
        ValveUsage valveUsage51 = new ValveUsage(UUID.fromString("0197a11b-4fa6-7676-94a2-6136619e5f7a"), vanne51, "X01", "1-3-5", false, new Point(605, 185));
        result.add(valveUsage51);

        SolenoidValve vanne52 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10969", -1);
        ValveUsage valveUsage52 = new ValveUsage(UUID.fromString("0197a11b-7504-72be-a41d-58b51e8dfd26"), vanne52, "X02", "1-3-6", false, new Point(605, 290));
        result.add(valveUsage52);

        SolenoidValve vanne53 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10971", -1);
        ValveUsage valveUsage53 = new ValveUsage(UUID.fromString("0197a11b-9cc2-7668-a720-b0b38efbded4"), vanne53, "X3", "1-3-7", false, new Point(605, 385));
        result.add(valveUsage53);

        SolenoidValve vanne54 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "20293", -1);
        ValveUsage valveUsage54 = new ValveUsage(UUID.randomUUID(), vanne54, "X1", "2-3-3", false, new Point(580, 85));
        result.add(valveUsage54);

        SolenoidValve vanne55 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "20609", -1);
        ValveUsage valveUsage55 = new ValveUsage(UUID.fromString("0197a11c-1292-783e-a555-7f037ebe7d29"), vanne55, "X41", "0-0-0", false, new Point(490, -20));
        result.add(valveUsage55);

        SolenoidValve vanne56 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "20611", -1);
        ValveUsage valveUsage56 = new ValveUsage(UUID.fromString("0197a11c-3a73-758a-a782-9963720a8b65"), vanne56, "X4", "2-3-6", false, new Point(605, -45));
        result.add(valveUsage56);
        
        SolenoidValve vanne57 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "20619", -1);
        ValveUsage valveUsage57 = new ValveUsage(UUID.fromString("0197a11c-a919-7df9-8a8b-7d887582fa23"), vanne57, "X42", "0-0-0", false, new Point(725, -20));
        result.add(valveUsage57);

        SolenoidValve vanne58 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "20623", -1);
        ValveUsage valveUsage58 = new ValveUsage(UUID.fromString("0197a28f-446a-7b6d-a160-69673633c861"), vanne58, "X05", "2-0-2", false, new Point(660, 380));
        result.add(valveUsage58);

        SolenoidValve vanne59 = new NormallyOpenedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyOpenedValve.class), "21902", -1);
        ValveUsage valveUsage59 = new ValveUsage(UUID.randomUUID(), vanne59, "X5", "1-0-2", false, new Point(595, 495));
        result.add(valveUsage59);

        SolenoidValve vanne60 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10621", -1);
        ValveUsage valveUsage60 = new ValveUsage(UUID.fromString("0197a11a-900e-71c6-9c0c-1cd3ea2f7bc7"), vanne60, "X121", "0-0-0", false, new Point(505, 135));
        result.add(valveUsage60);

        SolenoidValve vanne61 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10623", -1);
        ValveUsage valveUsage61 = new ValveUsage(UUID.fromString("0197a11a-ae79-7ac3-9ec3-06420f05d415"), vanne61, "X221", "0-0-0", false, new Point(705, 135));
        result.add(valveUsage61);

        SolenoidValve vanne62 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10631", -1);
        ValveUsage valveUsage62 = new ValveUsage(UUID.fromString("0197a11a-f8dc-7716-91a4-f382840495ff"), vanne62, "X222", "0-0-0", false, new Point(705, 240));
        result.add(valveUsage62);

        SolenoidValve vanne63 = new NormallyClosedValve(UUID.randomUUID(), TestModelRegistry.getDefaultModel(NormallyClosedValve.class), "10629", -1);
        ValveUsage valveUsage63 = new ValveUsage(UUID.fromString("0197a11a-d2ce-7429-8db8-52f0978f656b"), vanne63, "X122", "0-0-0", false, new Point(505, 240));
        result.add(valveUsage63);

        Diverter vanne64 = new Diverter(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Diverter.class), "21882", -1);
        DiverterUsage valveUsage64 = new DiverterUsage(UUID.fromString("0197a11d-1cc8-7fcb-8667-9cfda30b16ea"), vanne64, "A1", "2-3-4", false, new Point(515, 680));
        result.add(valveUsage64);

        Diverter vanne65 = new Diverter(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Diverter.class), "21888", -1);
        DiverterUsage valveUsage65 = new DiverterUsage(UUID.fromString("0197a11d-96f7-79fa-90f4-06d949da8ccb"), vanne65, "A2", "2-3-5", false, new Point(620, 680));
        result.add(valveUsage65);

        return result;
    }

    default List<IntakeUsage> generatedIntakeUsages(){
        List<IntakeUsage> result = new ArrayList<>();

        /* GAS INTAKE */
        /* low pressure intake */
        Intake airIntake1 = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "821", 2, Intake.Type.AIR);
        IntakeUsage airUsage1 = new IntakeUsage(UUID.fromString("0197a101-cc89-768c-8cb4-ac8950808448"), airIntake1, "A", new Point(200, 615));
        result.add(airUsage1);

        Intake airIntake2 = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "841", 2, Intake.Type.AIR);
        IntakeUsage airUsage2 = new IntakeUsage(UUID.fromString("0197a103-1e29-7de3-a630-77b0bcd4bbb7"), airIntake2, "A", new Point(390, 615));
        result.add(airUsage2);

        Intake airIntake3 = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "995", -1, Intake.Type.AIR);
        IntakeUsage airUsage3 = new IntakeUsage(UUID.fromString("0197a10d-6ef5-7881-94e9-849e443c42b0"), airIntake3, "A", new Point(1200, 615));
        result.add(airUsage3);

        Intake airIntake4 = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "1015", -1, Intake.Type.AIR);
        IntakeUsage airUsage4 = new IntakeUsage(UUID.fromString("0197a10e-5f69-760f-85b4-25b2df391451"), airIntake4, "A", new Point(1000, 615));
        result.add(airUsage4);
        /* high pressure intake */

        Intake highFlowAirIntake1 = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "20604", -1, Intake.Type.HIGH_FLOW_AIR);
        IntakeUsage highFlowAirUsage1 = new IntakeUsage(UUID.fromString("0197a11b-effe-7aad-a3e1-1ffe5e7a4e86"), highFlowAirIntake1, "H", new Point(925, 15));
        result.add(highFlowAirUsage1);

        Intake highFlowAirIntake2 = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "20608", -1, Intake.Type.HIGH_FLOW_AIR);
        IntakeUsage highFlowAirUsage2 = new IntakeUsage(UUID.fromString("0197a11b-c13a-71ca-8cee-69d027d4b75f"), highFlowAirIntake2, "H", new Point(285, 15));
        result.add(highFlowAirUsage2);

        Intake highFlowAirIntake3 = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "20618", -1, Intake.Type.HIGH_FLOW_AIR);
        IntakeUsage highFlowAirUsage3 = new IntakeUsage(UUID.fromString("0197a11c-89ff-716b-b42c-2eb1430d3390"), highFlowAirIntake3, "H", new Point(605, -75));
        result.add(highFlowAirUsage3);

        /* LIQUID INTAKE */
        /* suply intake */
        Intake waterIntake = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "10468", -1, Intake.Type.WATER);
        IntakeUsage waterUsage = new IntakeUsage(UUID.fromString("0197a110-3ca2-7b48-a6ba-a3988fb755fe"), waterIntake, "W", new Point(605, 115));
        result.add(waterUsage);

        Intake sodaIntake = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "10490", -1, Intake.Type.SODA);
        IntakeUsage sodaUsage = new IntakeUsage(UUID.fromString("0197a111-adc6-7e80-8aaf-002ed00f3dd8"), sodaIntake, "S", new Point(605, 415));
        result.add(sodaUsage);

        Intake oxydantIntake = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "", -1, Intake.Type.OXYDANT);
        IntakeUsage oxydantUsage = new IntakeUsage(UUID.fromString("0197a135-ee93-7ad9-8ec0-9d84d77f18d6"), oxydantIntake, "O", new Point(665, 415));
        result.add(oxydantUsage);


        /* media intake */
        Intake mediaIntake1 = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "10494", -1, Intake.Type.MEDIUM);
        IntakeUsage mediaUsage1 = new IntakeUsage(UUID.fromString("0197a111-ed96-77cc-8d6e-506ca50491ef"), mediaIntake1, "M1", new Point(605, 215));
        result.add(mediaUsage1);

        Intake mediaIntake2 = new Intake(UUID.randomUUID(), TestModelRegistry.getDefaultModel(Intake.class), "10514", -1, Intake.Type.MEDIUM);
        IntakeUsage mediaUsage2 = new IntakeUsage(UUID.fromString("0197a113-72e1-7b43-8aaa-1c1c06ccb02f"), mediaIntake2, "M2", new Point(605, 320));
        result.add(mediaUsage2);
        
        return result;

    }

    default <T extends ComponentUsage> T getUsageById(List<T> usages, UUID id){
        return usages.stream().filter(usage -> usage.getId().equals(id)).findFirst().orElse(null);
    }

    default void handleConnection(List<FluidicComponantUsage> usages) {
        // Retrieve all necessary usages
        FluidicComponantUsage usage21919 = getUsageById(usages, UUID.fromString("0197a0fd-a6da-7c24-83ff-ecaadd2a3f14"));
        FluidicComponantUsage usage21927 = getUsageById(usages, UUID.fromString("0197a0fe-0ec4-70b9-bf87-9196a7898c31"));
        FluidicComponantUsage usage21929 = getUsageById(usages, UUID.fromString("0197a0fe-71b6-75ce-9ee3-4037afc89ecf"));
        FluidicComponantUsage usage21931 = getUsageById(usages, UUID.fromString("0197a0ff-373a-7f8d-8cd7-b576e2456322"));
        FluidicComponantUsage usage21933 = getUsageById(usages, UUID.fromString("0197a0ff-6589-71bb-9b62-ef3e63f9afca"));
        FluidicComponantUsage usage21935 = getUsageById(usages, UUID.fromString("0197a0ff-a7df-7a94-8274-8ccc2b42ca8b"));
        FluidicComponantUsage usage21937 = getUsageById(usages, UUID.fromString("0197a100-5979-7359-b59c-f441b3a7c50b"));
        FluidicComponantUsage usage21939 = getUsageById(usages, UUID.fromString("0197a100-d222-7827-91a6-ef4a54e6e676"));
        FluidicComponantUsage usage21941 = getUsageById(usages, UUID.fromString("0197a100-ff97-7b29-b3ff-da9b1be26cd3"));
        FluidicComponantUsage usage21943 = getUsageById(usages, UUID.fromString("0197a101-9e20-773e-86dd-21806629e1c1"));
        FluidicComponantUsage usage21945 = getUsageById(usages, UUID.fromString("0197a101-cc89-768c-8cb4-ac8950808448"));
        FluidicComponantUsage usage21947 = getUsageById(usages, UUID.fromString("0197a102-023f-7add-87c0-10d51ae04971"));
        FluidicComponantUsage usage21949 = getUsageById(usages, UUID.fromString("0197a102-331a-7a7c-a617-9116746d5e59"));
        FluidicComponantUsage usage21957 = getUsageById(usages, UUID.fromString("0197a102-5dc1-716a-90cd-9cf23a214184"));
        FluidicComponantUsage usage21959 = getUsageById(usages, UUID.fromString("0197a102-8e2d-7856-9149-6ab21bea3d54"));
        FluidicComponantUsage usage21961 = getUsageById(usages, UUID.fromString("0197a102-ba6c-7b77-ba05-75eb9125e33c"));
        FluidicComponantUsage usage21963 = getUsageById(usages, UUID.fromString("0197a102-ee2c-7bd7-81d1-959b5b0add2c"));
        FluidicComponantUsage usage21965 = getUsageById(usages, UUID.fromString("0197a103-1e29-7de3-a630-77b0bcd4bbb7"));
        FluidicComponantUsage usage21967 = getUsageById(usages, UUID.fromString("0197a103-4c26-7cba-b711-3eb765a08041"));
        FluidicComponantUsage usage21969 = getUsageById(usages, UUID.fromString("0197a103-7a5c-7b34-ab4b-4a677813f855"));
        FluidicComponantUsage usage21971 = getUsageById(usages, UUID.fromString("0197a103-b9af-7711-b374-612dfc263179"));
        FluidicComponantUsage usage21973 = getUsageById(usages, UUID.fromString("0197a103-db4f-7b4f-a33d-bcd28660fecf"));
        FluidicComponantUsage usage21975 = getUsageById(usages, UUID.fromString("0197a104-1c98-7db5-95a5-3aa23bf01668"));
        FluidicComponantUsage usage21977 = getUsageById(usages, UUID.fromString("0197a104-41d4-7c0a-b7ff-08f61c9f02c1"));
        FluidicComponantUsage usage21979 = getUsageById(usages, UUID.fromString("0197a104-6cae-75ac-943b-dfd2d53b2ba3"));
        FluidicComponantUsage usage21981 = getUsageById(usages, UUID.fromString("0197a104-94fa-7735-af33-19aeccb080a0"));
        FluidicComponantUsage usage21983 = getUsageById(usages, UUID.fromString("0197a104-d3b4-7906-a038-8a6aae4f3afe"));
        FluidicComponantUsage usage21985 = getUsageById(usages, UUID.fromString("0197a107-1df9-793d-89cd-ab2936999179"));
        FluidicComponantUsage usage21987 = getUsageById(usages, UUID.fromString("0197a107-4d9e-7d9b-87eb-37238e02b8cf"));
        FluidicComponantUsage usage21989 = getUsageById(usages, UUID.fromString("0197a107-c8b9-78d8-b051-99e91e51b582"));
        FluidicComponantUsage usage21991 = getUsageById(usages, UUID.fromString("0197a108-179f-78a8-a168-d8b112b2795f"));
        FluidicComponantUsage usage21993 = getUsageById(usages, UUID.fromString("0197a108-47f0-7946-80ad-6d8e03e1cc0e"));
        FluidicComponantUsage usage21995 = getUsageById(usages, UUID.fromString("0197a108-71e0-75f2-87f4-31824451b422"));
        FluidicComponantUsage usage21997 = getUsageById(usages, UUID.fromString("0197a10a-17a9-7fc4-95d4-aa4a96891418"));
        FluidicComponantUsage usage21999 = getUsageById(usages, UUID.fromString("0197a115-2098-79c8-8e70-63cddbf25a30"));
        FluidicComponantUsage usage22001 = getUsageById(usages, UUID.fromString("0197a10a-6f97-7b94-80d3-4860392b24a0"));
        FluidicComponantUsage usage22009 = getUsageById(usages, UUID.fromString("0197a10a-989e-7e39-8caf-3a407ef2531c"));
        FluidicComponantUsage usage22011 = getUsageById(usages, UUID.fromString("0197a10b-8c96-73df-b56b-1bb5aa9c973c"));
        FluidicComponantUsage usage22013 = getUsageById(usages, UUID.fromString("0197a10b-cd28-77c1-9bfc-8b41544b5f29"));
        FluidicComponantUsage usage22015 = getUsageById(usages, UUID.fromString("0197a10b-f5a3-7117-9a03-8c9c4250e2ce"));
        FluidicComponantUsage usage22017 = getUsageById(usages, UUID.fromString("0197a10c-5f0e-7f93-8238-41f5cf8f3ae1"));
        FluidicComponantUsage usage22019 = getUsageById(usages, UUID.fromString("0197a10c-a367-74f1-aebc-143944b34d7a"));
        FluidicComponantUsage usage22021 = getUsageById(usages, UUID.fromString("0197a10c-ca66-7968-b6cb-39502b3b31a3"));
        FluidicComponantUsage usage22023 = getUsageById(usages, UUID.fromString("0197a10c-f4bf-7d42-8456-cad529b62c45"));
        FluidicComponantUsage usage22025 = getUsageById(usages, UUID.fromString("0197a10d-1647-7079-b1ba-77dead06e8b2"));
        FluidicComponantUsage usage22027 = getUsageById(usages, UUID.fromString("0197a10d-3f29-7b3b-8b8d-ab4e85f7a0f3"));
        FluidicComponantUsage usage22029 = getUsageById(usages, UUID.fromString("0197a10d-6ef5-7881-94e9-849e443c42b0"));
        FluidicComponantUsage usage22031 = getUsageById(usages, UUID.fromString("0197a10d-8e20-7361-bf74-135732905fc7"));
        FluidicComponantUsage usage22039 = getUsageById(usages, UUID.fromString("0197a10d-b4b5-713e-97ec-7a7e4658517e"));
        FluidicComponantUsage usage22041 = getUsageById(usages, UUID.fromString("0197a10d-dd31-76fa-af1b-24d0815918fb"));
        FluidicComponantUsage usage22043 = getUsageById(usages, UUID.fromString("0197a10e-07d8-7a9c-a06e-63237f7409a4"));
        FluidicComponantUsage usage22045 = getUsageById(usages, UUID.fromString("0197a10e-3288-76e1-9ffd-82ea679a8e41"));
        FluidicComponantUsage usage22047 = getUsageById(usages, UUID.fromString("0197a10e-5f69-760f-85b4-25b2df391451"));
        FluidicComponantUsage usage22049 = getUsageById(usages, UUID.fromString("0197a10e-9649-74e2-97f4-375ff72b8597"));
        FluidicComponantUsage usage22051 = getUsageById(usages, UUID.fromString("0197a10e-f87b-7d64-b977-cb58b8fe309d"));
        FluidicComponantUsage usage22053 = getUsageById(usages, UUID.fromString("0197a10f-1d3a-772e-bdb3-34d92193b252"));
        FluidicComponantUsage usage22055 = getUsageById(usages, UUID.fromString("0197a10f-3f08-7b80-b125-896596bf7035"));
        FluidicComponantUsage usage22057 = getUsageById(usages, UUID.fromString("0197a10f-6299-7dc7-aa4b-5fe4d9c2a7a4"));
        FluidicComponantUsage usage22059 = getUsageById(usages, UUID.fromString("0197a10f-8bfe-7782-ba5f-902cfa77014c"));
        FluidicComponantUsage usage22061 = getUsageById(usages, UUID.fromString("0197a10f-b1bc-7db5-941e-cd1c643dbff9"));
        FluidicComponantUsage usage22063 = getUsageById(usages, UUID.fromString("0197a10f-d32b-79b5-a75b-6589d9463751"));
        FluidicComponantUsage usage22065 = getUsageById(usages, UUID.fromString("0197a10f-f598-75c2-af9a-3de61ebe2298"));
        FluidicComponantUsage usage22067 = getUsageById(usages, UUID.fromString("0197a110-17f8-78dc-a34e-86fb3f30a701"));
        FluidicComponantUsage usage22069 = getUsageById(usages, UUID.fromString("0197a110-3ca2-7b48-a6ba-a3988fb755fe"));
        FluidicComponantUsage usage22073 = getUsageById(usages, UUID.fromString("0197a110-67cc-760d-b1d1-7e9708190d64"));
        FluidicComponantUsage usage22075 = getUsageById(usages, UUID.fromString("0197a110-8ff7-7b6c-81f5-1d34451de0f9"));
        FluidicComponantUsage usage22077 = getUsageById(usages, UUID.fromString("0197a110-bb50-7cbe-a3e5-48fc1d13b41d"));
        FluidicComponantUsage usage22079 = getUsageById(usages, UUID.fromString("0197a110-e397-75e5-8a46-e7b82d828029"));
        FluidicComponantUsage usage22081 = getUsageById(usages, UUID.fromString("0197a111-07d4-797d-b3f8-440bb4314c78"));
        FluidicComponantUsage usage22083 = getUsageById(usages, UUID.fromString("0197a111-3622-7956-bad1-4f091e767ca2"));
        FluidicComponantUsage usage22085 = getUsageById(usages, UUID.fromString("0197a111-57dd-7677-ae14-79145500f3f4"));
        FluidicComponantUsage usage22087 = getUsageById(usages, UUID.fromString("0197a111-adc6-7e80-8aaf-002ed00f3dd8"));
        FluidicComponantUsage usage22091 = getUsageById(usages, UUID.fromString("0197a111-ed96-77cc-8d6e-506ca50491ef"));
        FluidicComponantUsage usage22097 = getUsageById(usages, UUID.fromString("0197a112-1ac9-7839-a9c8-a58bb01fdb8b"));
        FluidicComponantUsage usage22099 = getUsageById(usages, UUID.fromString("0197a112-4639-7027-9da3-3caa870a4d20"));
        FluidicComponantUsage usage22101 = getUsageById(usages, UUID.fromString("0197a112-6d0c-79a9-8e31-86fd29cbfd01"));
        FluidicComponantUsage usage22103 = getUsageById(usages, UUID.fromString("0197a112-8f14-7ca7-a6dc-725f99bc5356"));
        FluidicComponantUsage usage22105 = getUsageById(usages, UUID.fromString("0197a112-b83e-76a3-bd53-57983a9db38c"));
        FluidicComponantUsage usage22107 = getUsageById(usages, UUID.fromString("0197a112-da49-758a-b762-3e8da4f3185e"));
        FluidicComponantUsage usage22109 = getUsageById(usages, UUID.fromString("0197a113-0467-7eed-9b76-2da2a0331976"));
        FluidicComponantUsage usage22111 = getUsageById(usages, UUID.fromString("0197a113-2ba8-75a2-9dca-535b6f885bf0"));
        FluidicComponantUsage usage22113 = getUsageById(usages, UUID.fromString("0197a113-4d56-7e04-8443-0f70ac2b34a6"));
        FluidicComponantUsage usage22115 = getUsageById(usages, UUID.fromString("0197a113-72e1-7b43-8aaa-1c1c06ccb02f"));
        FluidicComponantUsage usage22121 = getUsageById(usages, UUID.fromString("0197a113-a913-79ed-b111-b039081c384d"));
        FluidicComponantUsage usage22123 = getUsageById(usages, UUID.fromString("0197a113-cf4b-7c2c-b68e-ab71f0b3d3bb"));
        FluidicComponantUsage usage22125 = getUsageById(usages, UUID.fromString("0197a115-4f48-77df-ad24-683d89136558"));
        FluidicComponantUsage usage22127 = getUsageById(usages, UUID.fromString("0197a115-7ad9-79c7-816e-27ab1213211c"));
        FluidicComponantUsage usage22129 = getUsageById(usages, UUID.fromString("0197a115-9de1-77cc-86e3-140672e49381"));
        FluidicComponantUsage usage22131 = getUsageById(usages, UUID.fromString("0197a115-d2c9-77f2-975f-e6695e9a1418"));
        FluidicComponantUsage usage22133 = getUsageById(usages, UUID.fromString("0197a115-f60e-7de2-aaf7-01d3541a092b"));
        FluidicComponantUsage usage22135 = getUsageById(usages, UUID.fromString("0197a116-1ded-7ef4-8706-97940ea78441"));
        FluidicComponantUsage usage22137 = getUsageById(usages, UUID.fromString("0197a116-3dde-7f4a-9cd5-518a7d662ea3"));
        FluidicComponantUsage usage22139 = getUsageById(usages, UUID.fromString("0197a116-5fe8-7de7-9463-8102fb8a64e9"));
        FluidicComponantUsage usage22141 = getUsageById(usages, UUID.fromString("0197a116-810e-746e-b623-7db255d60210"));
        FluidicComponantUsage usage22143 = getUsageById(usages, UUID.fromString("0197a116-cfdc-7d3e-9a8d-c3dd576cf566"));
        FluidicComponantUsage usage22145 = getUsageById(usages, UUID.fromString("0197a117-9e88-7e94-838f-80be330d07a2"));
        FluidicComponantUsage usage22147 = getUsageById(usages, UUID.fromString("0197a117-f4ca-7791-b8a8-f07d78374ea5"));
        FluidicComponantUsage usage22149 = getUsageById(usages, UUID.fromString("0197a118-1eb1-766d-adbd-5235b3d2098e"));
        FluidicComponantUsage usage22151 = getUsageById(usages, UUID.fromString("0197a118-56ea-706c-8e8e-f3d7afb8ae58"));
        FluidicComponantUsage usage22153 = getUsageById(usages, UUID.fromString("0197a118-95c7-7990-ae00-cd29919bbde8"));
        FluidicComponantUsage usage22155 = getUsageById(usages, UUID.fromString("0197a118-bdaa-7ea2-a93c-8eaf73727aac"));
        FluidicComponantUsage usage22157 = getUsageById(usages, UUID.fromString("0197a118-eacf-7e74-8211-bf2e72ebd0a6"));
        FluidicComponantUsage usage22159 = getUsageById(usages, UUID.fromString("0197a119-12b4-73b3-b4ab-4a5acdcbf480"));
        FluidicComponantUsage usage22161 = getUsageById(usages, UUID.fromString("0197a119-3979-785f-abd0-f503e0599a22"));
        FluidicComponantUsage usage22163 = getUsageById(usages, UUID.fromString("0197a119-5d4c-7a7c-9776-b4f19148106c"));
        FluidicComponantUsage usage22165 = getUsageById(usages, UUID.fromString("0197a119-8730-73f9-8d6a-d2114c0bc084"));
        FluidicComponantUsage usage22167 = getUsageById(usages, UUID.fromString("0197a119-ade7-7018-b0f7-83282379c263"));
        FluidicComponantUsage usage22169 = getUsageById(usages, UUID.fromString("0197a119-d215-7ddf-8536-3d2410759d40"));
        FluidicComponantUsage usage22171 = getUsageById(usages, UUID.fromString("0197a119-f7aa-76df-8a18-39f46009f873"));
        FluidicComponantUsage usage22173 = getUsageById(usages, UUID.fromString("0197a11a-1c02-717c-8b07-20bd42229945"));
        FluidicComponantUsage usage22175 = getUsageById(usages, UUID.fromString("0197a11a-6cb8-73e8-bee7-e26c99b36c43"));
        FluidicComponantUsage usage22177 = getUsageById(usages, UUID.fromString("0197a11a-900e-71c6-9c0c-1cd3ea2f7bc7"));
        FluidicComponantUsage usage22179 = getUsageById(usages, UUID.fromString("0197a11a-ae79-7ac3-9ec3-06420f05d415"));
        FluidicComponantUsage usage22181 = getUsageById(usages, UUID.fromString("0197a11a-d2ce-7429-8db8-52f0978f656b"));
        FluidicComponantUsage usage22183 = getUsageById(usages, UUID.fromString("0197a11a-f8dc-7716-91a4-f382840495ff"));
        FluidicComponantUsage usage22185 = getUsageById(usages, UUID.fromString("0197a11b-219c-7c79-bb57-f2c2cb56e5c8"));
        FluidicComponantUsage usage22187 = getUsageById(usages, UUID.fromString("0197a11b-4fa6-7676-94a2-6136619e5f7a"));
        FluidicComponantUsage usage22189 = getUsageById(usages, UUID.fromString("0197a11b-7504-72be-a41d-58b51e8dfd26"));
        FluidicComponantUsage usage22191 = getUsageById(usages, UUID.fromString("0197a11b-9cc2-7668-a720-b0b38efbded4"));
        FluidicComponantUsage usage22195 = getUsageById(usages, UUID.fromString("0197a11b-effe-7aad-a3e1-1ffe5e7a4e86"));
        FluidicComponantUsage usage22197 = getUsageById(usages, UUID.fromString("0197a11b-c13a-71ca-8cee-69d027d4b75f"));
        FluidicComponantUsage usage22199 = getUsageById(usages, UUID.fromString("0197a11c-1292-783e-a555-7f037ebe7d29"));
        FluidicComponantUsage usage22201 = getUsageById(usages, UUID.fromString("0197a11c-3a73-758a-a782-9963720a8b65"));
        FluidicComponantUsage usage22203 = getUsageById(usages, UUID.fromString("0197a11c-6343-7fdb-889e-78bf57e7ec69"));
        FluidicComponantUsage usage22205 = getUsageById(usages, UUID.fromString("0197a11c-89ff-716b-b42c-2eb1430d3390"));
        FluidicComponantUsage usage22207 = getUsageById(usages, UUID.fromString("0197a11c-a919-7df9-8a8b-7d887582fa23"));
        FluidicComponantUsage usage22209 = getUsageById(usages, UUID.fromString("0197a11c-ce53-70ae-a0b7-abfdd43eefe9"));
        FluidicComponantUsage usage22211 = getUsageById(usages, UUID.fromString("0197a11c-f758-7c23-9d9a-a94333787610"));
        FluidicComponantUsage usage22215 = getUsageById(usages, UUID.fromString("0197a11d-1cc8-7fcb-8667-9cfda30b16ea"));
        FluidicComponantUsage usage22217 = getUsageById(usages, UUID.fromString("0197a11d-4829-7d43-96f7-3cba0e770b54"));
        FluidicComponantUsage usage22219 = getUsageById(usages, UUID.fromString("0197a11d-7015-77fe-bf14-c50bc4e078f4"));
        FluidicComponantUsage usage22221 = getUsageById(usages, UUID.fromString("0197a11d-96f7-79fa-90f4-06d949da8ccb"));
        FluidicComponantUsage oxydantUsage = getUsageById(usages,UUID.fromString("0197a135-ee93-7ad9-8ec0-9d84d77f18d6"));
        FluidicComponantUsage X05ValveUsage = getUsageById(usages,UUID.fromString("0197a28f-446a-7b6d-a160-69673633c861"));
        // Connecting the components
        usage21919.connect(1,usage21941,0);
        usage21919.connect(0,usage21935,0);
        usage21919.connect(2,usage21933,0);
        usage21919.connect(3,usage21939,0);
        usage21927.connect(0,usage21947,1);
        usage21927.connect(1,usage21939,1);
        usage21929.connect(1,usage21941,1);
        usage21929.connect(0,usage21943,2);
        usage21931.connect(1,usage21939,2);
        usage21931.connect(0,usage21943,0);
        usage21933.connect(1,usage21937,1);
        usage21933.connect(0,usage21919,2);
        usage21935.connect(0,usage21919,0);
        usage21935.connect(1,usage21937,2);
        usage21937.connect(2,usage21935,1);
        usage21937.connect(1,usage21933,1);
        usage21937.connect(0,usage21979,2);
        usage21939.connect(0,usage21919,3);
        usage21939.connect(1,usage21927,1);
        usage21939.connect(2,usage21931,1);
        usage21941.connect(0,usage21919,1);
        usage21941.connect(1,usage21929,1);
        usage21941.connect(2,usage21985,0);
        usage21943.connect(2,usage21929,0);
        usage21943.connect(0,usage21931,0);
        usage21943.connect(1,usage22057,0);
        usage21945.connect(0,usage21985,1);
        usage21947.connect(1,usage21927,0);
        usage21949.connect(1,usage21963,0);
        usage21949.connect(0,usage21969,0);
        usage21949.connect(3,usage21971,0);
        usage21949.connect(2,usage21977,0);
        usage21957.connect(1,usage21963,1);
        usage21957.connect(0,usage21967,2);
        usage21959.connect(0,usage21975,1);
        usage21959.connect(1,usage21971,1);
        usage21961.connect(1,usage21977,1);
        usage21961.connect(2,usage21969,1);
        usage21961.connect(0,usage21979,0);
        usage21963.connect(0,usage21949,1);
        usage21963.connect(1,usage21957,1);
        usage21963.connect(2,usage21983,0);
        usage21965.connect(0,usage21983,1);
        usage21967.connect(2,usage21957,0);
        usage21967.connect(0,usage21973,0);
        usage21967.connect(1,usage22057,2);
        usage21969.connect(0,usage21949,0);
        usage21969.connect(1,usage21961,2);
        usage21971.connect(0,usage21949,3);
        usage21971.connect(1,usage21959,1);
        usage21971.connect(2,usage21973,1);
        usage21973.connect(1,usage21971,2);
        usage21973.connect(0,usage21967,0);
        usage21975.connect(1,usage21959,0);
        usage21977.connect(1,usage21961,1);
        usage21977.connect(0,usage21949,2);
        usage21979.connect(2,usage21937,0);
        usage21979.connect(0,usage21961,0);
        usage21979.connect(1,usage22053,0);
        usage21981.connect(0,usage22061,1);
        usage21981.connect(1,usage22163,0);
        usage21983.connect(0,usage21963,2);
        usage21983.connect(1,usage21965,0);
        usage21985.connect(0,usage21941,2);
        usage21985.connect(1,usage21945,0);
        usage21987.connect(0,usage22013,0);
        usage21987.connect(2,usage22019,0);
        usage21987.connect(1,usage22055,0);
        usage21989.connect(0,usage22001,0);
        usage21989.connect(1,usage22041,2);
        usage21991.connect(1,usage22021,1);
        usage21991.connect(0,usage22027,1);
        usage21993.connect(1,usage22047,0);
        usage21993.connect(0,usage22045,2);
        usage21995.connect(1,usage22029,0);
        usage21995.connect(0,usage22039,2);
        usage21997.connect(1,usage22017,2);
        usage21997.connect(0,usage22031,0);
        usage21999.connect(0,usage22049,1);
        usage21999.connect(1,usage22015,1);
        usage22001.connect(2,usage22025,0);
        usage22001.connect(0,usage21989,0);
        usage22001.connect(1,usage22039,0);
        usage22001.connect(3,usage22021,0);
        usage22009.connect(2,usage22017,0);
        usage22009.connect(0,usage22041,0);
        usage22009.connect(1,usage22059,0);
        usage22011.connect(0,usage22023,2);
        usage22011.connect(1,usage22039,1);
        usage22013.connect(1,usage22015,2);
        usage22013.connect(0,usage21987,0);
        usage22015.connect(1,usage21999,1);
        usage22015.connect(2,usage22013,1);
        usage22015.connect(0,usage22031,3);
        usage22017.connect(2,usage21997,1);
        usage22017.connect(0,usage22009,2);
        usage22017.connect(1,usage22051,1);
        usage22019.connect(1,usage22045,1);
        usage22019.connect(0,usage21987,2);
        usage22021.connect(1,usage21991,1);
        usage22021.connect(2,usage22043,1);
        usage22021.connect(0,usage22001,3);
        usage22023.connect(2,usage22011,0);
        usage22023.connect(0,usage22043,0);
        usage22023.connect(1,usage22055,2);
        usage22025.connect(0,usage22001,2);
        usage22025.connect(1,usage22041,1);
        usage22027.connect(1,usage21991,0);
        usage22029.connect(0,usage21995,1);
        usage22031.connect(3,usage22015,0);
        usage22031.connect(2,usage22051,0);
        usage22031.connect(1,usage22045,0);
        usage22031.connect(0,usage21997,0);
        usage22039.connect(0,usage22001,1);
        usage22039.connect(1,usage22011,1);
        usage22039.connect(2,usage21995,0);
        usage22041.connect(0,usage22009,0);
        usage22041.connect(1,usage22025,1);
        usage22041.connect(2,usage21989,1);
        usage22043.connect(1,usage22021,2);
    
        usage22043.connect(0,usage22023,0);
        usage22045.connect(1,usage22019,1);
        usage22045.connect(0,usage22031,1);
        usage22045.connect(2,usage21993,0);
        usage22047.connect(0,usage21993,1);
        usage22049.connect(1,usage21999,0);
        usage22051.connect(0,usage22031,2);
        usage22051.connect(1,usage22017,1);
        usage22053.connect(0,usage21979,1);
        usage22053.connect(1,usage22161,1);
        usage22055.connect(2,usage22023,1);
        usage22055.connect(0,usage21987,1);
        usage22055.connect(1,usage22155,1);
        usage22057.connect(2,usage21967,1);
        usage22057.connect(0,usage21943,1);
        usage22057.connect(1,usage22153,0);
        usage22059.connect(0,usage22009,1);
        usage22059.connect(1,usage22169,1);
        usage22061.connect(2,usage22161,0);
        usage22061.connect(1,usage21981,0);
        usage22061.connect(0,usage22151,1);
        usage22063.connect(1,usage22065,0);
        usage22063.connect(0,usage22203,2);
        usage22065.connect(1,usage22067,0);
        usage22065.connect(2,usage22075,0);
        usage22065.connect(0,usage22063,1);
        usage22067.connect(0,usage22065,1);
        usage22067.connect(1,usage22143,1);
        usage22069.connect(0,usage22185,1);
        usage22073.connect(0,usage22085,0);
        usage22073.connect(2,usage22083,1);
        usage22073.connect(1,usage22185,0);
        usage22075.connect(1,usage22083,0);
        usage22075.connect(0,usage22065,2);
        usage22075.connect(2,usage22077,0);
        usage22077.connect(2,usage22079,0);
        usage22077.connect(1,usage22109,0);
        usage22077.connect(0,usage22075,2);
        usage22079.connect(0,usage22077,2);
        usage22079.connect(2,usage22081,0);
        usage22079.connect(1,usage22113,0);
        usage22081.connect(0,usage22079,2);
        usage22081.connect(1,usage22131,0);
        usage22081.connect(2,usage22149,1);
        usage22083.connect(1,usage22073,2);
        usage22083.connect(0,usage22075,1);
        usage22085.connect(0,usage22073,0);
        usage22085.connect(1,usage22137,1);
        usage22087.connect(0,usage22191,1);
        usage22091.connect(0,usage22187,1);
        usage22097.connect(2,usage22103,1);
        usage22097.connect(0,usage22105,0);
        usage22097.connect(1,usage22187,0);
        usage22099.connect(0,usage22109,1);
        usage22099.connect(2,usage22103,0);
        usage22099.connect(1,usage22177,0);
        usage22101.connect(0,usage22105,1);
        usage22101.connect(2,usage22107,0);
        usage22101.connect(1,usage22179,1);
        usage22103.connect(0,usage22099,2);
        usage22103.connect(1,usage22097,2);
        usage22105.connect(0,usage22097,0);
        usage22105.connect(1,usage22101,0);
        usage22107.connect(0,usage22101,2);
        usage22107.connect(1,usage22139,1);
        usage22109.connect(0,usage22077,1);
        usage22109.connect(1,usage22099,0);
        usage22111.connect(0,usage22127,2);
        usage22111.connect(1,usage22129,2);
        usage22113.connect(1,usage22127,0);
        usage22113.connect(0,usage22079,1);
        usage22115.connect(0,usage22189,1);
        usage22121.connect(1,usage22123,0);
        usage22121.connect(0,usage22129,0);
        usage22123.connect(0,usage22121,1);
        usage22123.connect(2,usage22125,0);
        usage22123.connect(1,usage22183,1);
        usage22125.connect(0,usage22123,2);
        usage22125.connect(1,usage22141,1);
        usage22127.connect(2,usage22111,0);
        usage22127.connect(0,usage22113,1);
        usage22127.connect(1,usage22181,0);
        usage22129.connect(2,usage22111,1);
        usage22129.connect(0,usage22121,0);
        usage22129.connect(1,usage22189,0);
        usage22131.connect(0,usage22081,1);
        usage22131.connect(1,usage22135,2);
        usage22133.connect(1,usage22145,1);
        usage22133.connect(0,usage22135,0);
        usage22135.connect(2,usage22131,1);
        usage22135.connect(0,usage22133,0);
        usage22135.connect(1,usage22191,0);
        usage22137.connect(2,usage22143,0);
        usage22137.connect(1,usage22085,1);
        usage22137.connect(0,usage22139,2);
        usage22139.connect(0,usage22141,2);
        usage22139.connect(1,usage22107,1);
        usage22139.connect(2,usage22137,0);
        usage22141.connect(2,usage22139,0);
        usage22141.connect(0,usage22145,2);
        usage22141.connect(1,usage22125,1);
        usage22143.connect(0,usage22137,2);
        usage22143.connect(1,usage22067,1);
        usage22143.connect(2,usage22147,0);
        usage22145.connect(2,usage22141,0);
        usage22145.connect(1,usage22133,1);
        usage22145.connect(0,usage22157,1);
        usage22147.connect(0,usage22143,2);
        usage22147.connect(1,usage22209,0);
        usage22149.connect(2,usage22151,0);
        usage22149.connect(1,usage22081,2);
        usage22149.connect(0,usage22153,1);
        usage22151.connect(0,usage22149,2);
        usage22151.connect(1,usage22061,0);
        usage22153.connect(1,usage22149,0);
        usage22153.connect(0,usage22057,1);
        usage22155.connect(0,usage22157,2);
        usage22155.connect(1,usage22055,1);
        usage22157.connect(1,usage22145,0);
        usage22157.connect(2,usage22155,0);
        usage22157.connect(0,usage22159,1);
        usage22159.connect(0,usage22175,2);
        usage22159.connect(1,usage22157,0);
        usage22161.connect(0,usage22061,2);
        usage22161.connect(1,usage22053,1);
        usage22163.connect(0,usage21981,1);
        usage22163.connect(1,usage22215,0);
        usage22165.connect(0,usage22215,2);
        usage22167.connect(1,usage22221,2);
        usage22169.connect(0,usage22175,0);
        usage22169.connect(1,usage22059,1);
        usage22171.connect(0,usage22173,1);
        usage22171.connect(1,usage22175,1);
        usage22173.connect(1,usage22171,0);
        usage22173.connect(0,usage22221,0);
        usage22175.connect(0,usage22169,0);
        usage22175.connect(1,usage22171,1);
        usage22175.connect(2,usage22159,0);
        usage22177.connect(1,usage22179,0);
        usage22177.connect(0,usage22099,1);
        usage22179.connect(0,usage22177,1);
        usage22179.connect(1,usage22101,1);
        usage22181.connect(1,usage22183,0);
        usage22181.connect(0,usage22127,1);
        usage22183.connect(0,usage22181,1);
        usage22183.connect(1,usage22123,1);
        usage22185.connect(0,usage22073,1);
        usage22185.connect(1,usage22069,0);
        usage22187.connect(0,usage22097,1);
        usage22187.connect(1,usage22091,0);
        usage22189.connect(0,usage22129,1);
        usage22189.connect(1,usage22115,0);
        usage22191.connect(0,usage22135,1);
        usage22191.connect(1,usage22087,0);
        usage22195.connect(0,usage22209,2);
        usage22197.connect(0,usage22203,0);
        usage22199.connect(0,usage22203,1);
        usage22199.connect(1,usage22211,0);
        usage22201.connect(0,usage22205,0);
        usage22201.connect(1,usage22211,1);
        usage22203.connect(0,usage22197,0);
        usage22203.connect(1,usage22199,0);
        usage22203.connect(2,usage22063,0);
        usage22205.connect(0,usage22201,0);
        usage22207.connect(0,usage22211,2);
        usage22207.connect(1,usage22209,1);
        usage22209.connect(2,usage22195,0);
        usage22209.connect(1,usage22207,1);
        usage22209.connect(0,usage22147,1);
        usage22211.connect(1,usage22201,1);
        usage22211.connect(2,usage22207,0);
        usage22211.connect(0,usage22199,1);
        usage22215.connect(1,usage22217,3);
        usage22215.connect(0,usage22163,1);
        usage22215.connect(2,usage22165,0);
        usage22217.connect(3,usage22215,1);
        usage22219.connect(2,usage22221,1);
        usage22221.connect(1,usage22219,2);
        usage22221.connect(0,usage22173,0);
        usage22221.connect(2,usage22167,1);
        //HELP 
        //oxydantUsage.connect(0, X05ValveUsage, 0);
        //X05ValveUsage.connect(1, TJoinOxonia, 0);
        //X2220 = usage22125
        //O2221 = usage22121
        //TJoinOxonia.connect(0,usage22125);
    }

} 