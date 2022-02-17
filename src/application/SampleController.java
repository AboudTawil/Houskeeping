package application;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import MyLib.Mymethode;
import dao.RoomsDAO;
import dao.RoomsSQLiteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import model.Room;

public class SampleController {
	public List<Room> roomsList;
	private int selectedRoomNr = 101;
	private Room selectedRoomObject;
	private RoomsDAO dao;
	@FXML
	private Button btn1;
	private int totalReadyRooms, totalNotReadyRooms, occupiedRooms;
	@FXML
	private PieChart pie, pie1, pie2, pie3;
	@FXML
	private Circle cr101, cr102, cr103, cr104, cr105, cr106, cr107, cr108, cr109, cr110, cr111, cr112, cr113, cr114,
			cr115, cr201, cr202, cr203, cr204, cr205, cr206, cr207, cr208, cr209, cr210, cr211, cr212, cr213, cr214,
			cr215, cr301, cr302, cr303, cr304, cr305, cr306, cr307, cr308, cr309, cr310, cr311, cr312, cr313, cr314,
			cr315, cr401, cr402, cr403, cr404, cr405, cr406, cr407, cr408, cr409, cr410, cr411, cr412, cr413, cr414,
			cr415, cr501, cr502, cr503, cr504, cr505, cr506, cr507, cr508, cr509, cr510, cr511, cr512, cr513, cr514,
			cr515, cr601, cr602, cr603, cr604, cr605, cr606, cr607, cr608, cr609, cr610, cr611, cr612, cr613, cr614,
			cr615, cr701, cr702, cr703, cr704, cr705, cr706, cr707, cr708, cr709, cr710, cr711, cr712, cr713, cr714,
			cr715, cr801, cr802, cr803, cr804, cr805, cr806, cr807, cr808, cr809, cr810, cr811, cr812, cr813, cr814,
			cr815, cr901, cr902, cr903, cr904, cr905, cr906, cr907, cr908, cr909, cr910, cr911, cr912, cr913, cr914,
			cr915;

	@FXML
	private Text t101, t102, t103, t104, t105, t106, t107, t108, t109, t110, t111, t112, t113, t114, t115, t201, t202,
			t203, t204, t205, t206, t207, t208, t209, t210, t211, t212, t213, t214, t215, t301, t302, t303, t304, t305,
			t306, t307, t308, t309, t310, t311, t312, t313, t314, t315, t401, t402, t403, t404, t405, t406, t407, t408,
			t409, t410, t411, t412, t413, t414, t415, t501, t502, t503, t504, t505, t506, t507, t508, t509, t510, t511,
			t512, t513, t514, t515, t601, t602, t603, t604, t605, t606, t607, t608, t609, t610, t611, t612, t613, t614,
			t615, t701, t702, t703, t704, t705, t706, t707, t708, t709, t710, t711, t712, t713, t714, t715, t801, t802,
			t803, t804, t805, t806, t807, t808, t809, t810, t811, t812, t813, t814, t815, t901, t902, t903, t904, t905,
			t906, t907, t908, t909, t910, t911, t912, t913, t914, t915;
	@FXML
	Text perReady, perOccupied, perNotReady;

	@FXML
	private Label textReadyRooms, textOccupiedRooms, textNotReadyRooms;

	@FXML
	private Circle situationCircle;

	@FXML
	private RadioButton notreadyRD, occupiedRD, readyRD;

	@FXML
	private Label t2RFour, t2ROne, t2RSix, t2RThree, t2RTotal, t2RTow;
	@FXML
	private Label t2OFour, t2OOne, t2OSix, t2OThree, t2OTolals, t2OTow;
	@FXML
	private Label label43, label13, label23, label33, label53, label63;

	@FXML
	private Label label54, label34, label64, label24, label14, label44;
	@FXML
	private Label label55, label35, label65, label25, label15, label45;
	@FXML
	private Label label56, label36, label66, label26, label16, label46;
	@FXML

	private Label t2NFour, t2NOne, t2NSix, t2NThree, t2NTotals, t2NTow;

	@FXML
	private Label label58, label38, label68, label28, label18, label48;
	@FXML
	private Label label510, label310, label610, label210, label110, label410;
	@FXML
	private Label label511, label311, label611, label211, label111, label411;

	@FXML
	private Label label59, label39, label69, label29, label19, label49;
	@FXML
	private ToggleGroup radiBtnGroup;
	@FXML
	private Text roomSituationText;
	@FXML
	private CheckBox getLanchk, setLanchk, cleanroomchk, technickchk;

	@FXML
	private Label roomBedsLabel;

	@FXML
	private ToolBar roomDetails;

	@FXML
	private Label roomIdLabel;

	@FXML
	private void leerLabels() {
		ArrayList<Label> arrLanels = new ArrayList<Label>(Arrays.asList(t2RFour, t2ROne, t2RSix, t2RThree, t2RTotal,
				t2RTow, t2OFour, t2OOne, t2OSix, t2OThree, t2OTolals, t2OTow, label43, label13, label23, label33,
				label53, label63, label54, label34, label64, label24, label14, label44, label55, label35, label65,
				label25, label15, label45, label56, label36, label66, label26, label16, label46, t2NFour, t2NOne,
				t2NSix, t2NThree, t2NTotals, t2NTow, label58, label38, label68, label28, label18, label48, label510,
				label310, label610, label210, label110, label410, label511, label311, label611, label211, label111,
				label411, label59, label39, label69, label29, label19, label49));

		for (Label labelT2 : arrLanels) {
			labelT2.setText("0");
		}
	}

	@FXML
	void onCheckOut(ActionEvent event) {

		if (selectedRoomObject.getSituation() == 5) {
			selectedRoomObject.setCleanRoom(0);
			selectedRoomObject.setGetLandery(0);
			selectedRoomObject.setNeedTechnick(0);
			selectedRoomObject.setGetLandery(0);
			selectedRoomObject.setSituation(0);
			// wir sollen das room Obj in DB aktuellieren

			boolean b = dao.update(selectedRoomObject);
			System.out.println("did es Save :" + b);
			leerLabels();
			initAllRoomsColors();
			roomDetails.setVisible(false);
		}

	}

	@FXML
	void onTestCR(MouseEvent event) {
		roomDetails.setVisible(true);

		String strName = ((Shape) event.getSource()).getId().toString();
		if (strName.length() < 5) {
			strName = strName.substring(1);
		} else {
			strName = strName.substring(2);
		}
		roomIdLabel.setText(strName);
		selectedRoomObject = Mymethode.getRoomByRoomId("cr" + strName, roomsList);
		selectedRoomNr = Integer.parseInt(strName);
		roomBedsLabel.setText(String.valueOf(selectedRoomObject.getBeds()));

		getLanchk.setSelected(Mymethode.isTrueChkBox(selectedRoomObject.getGetLandery()));
		setLanchk.setSelected(Mymethode.isTrueChkBox(selectedRoomObject.getSetLandery()));
		technickchk.setSelected(Mymethode.isTrueChkBox(selectedRoomObject.getNeedTechnick()));
		cleanroomchk.setSelected(Mymethode.isTrueChkBox(selectedRoomObject.getCleanRoom()));

		int totalSituation = selectedRoomObject.getGetLandery() + selectedRoomObject.getSetLandery()
				+ selectedRoomObject.getNeedTechnick() + selectedRoomObject.getCleanRoom();

		roomSituationText.setText(String.valueOf(totalSituation) + "%");

		switch (selectedRoomObject.getSituation()) {
		case 0: {
			notreadyRD.setSelected(true);
			break;
		}
		case 5: {
			occupiedRD.setSelected(true);
			break;
		}
		case 10: {
			readyRD.setSelected(true);
			break;
		}

		}

	}

	@FXML
	void onTest(ActionEvent event) {
		// not use
		System.out.println(((Control) event.getSource()).getId());
		roomDetails.setVisible(false);
		// System.out.println(((Shape )event.getSource()).getId().toString());

	}

	@FXML
	void onGetReadyRoom(ActionEvent event) {

		selectedRoomObject.setCleanRoom(25);
		selectedRoomObject.setGetLandery(25);
		selectedRoomObject.setNeedTechnick(25);
		selectedRoomObject.setSetLandery(25);
		selectedRoomObject.setSituation(10);
		boolean b = dao.update(selectedRoomObject);
		leerLabels();
		initAllRoomsColors();
		roomDetails.setVisible(false);

	}

	@FXML
	void onUpdate(ActionEvent event) {

		if (setLanchk.isSelected())
			selectedRoomObject.setSetLandery(25);
		else
			selectedRoomObject.setSetLandery(0);

		if (getLanchk.isSelected())
			selectedRoomObject.setGetLandery(25);
		else
			selectedRoomObject.setGetLandery(0);

		if (cleanroomchk.isSelected())
			selectedRoomObject.setCleanRoom(25);
		else
			selectedRoomObject.setCleanRoom(0);

		if (technickchk.isSelected())
			selectedRoomObject.setNeedTechnick(25);
		else
			selectedRoomObject.setNeedTechnick(0);
		if (readyRD.isSelected())
			selectedRoomObject.setSituation(10);
		if (notreadyRD.isSelected())
			selectedRoomObject.setSituation(0);
		if (occupiedRD.isSelected())
			selectedRoomObject.setSituation(5);

		// wir sollen das room Obj in DB aktuellieren

		boolean b = dao.update(selectedRoomObject);
		dao = new RoomsSQLiteDAO();
		roomsList.clear();
		roomsList = dao.getAll();
		leerLabels();
		initAllRoomsColors();
		roomDetails.setVisible(false);

	}

	@FXML
	void initOnMouseClickEventforCircle() {
// not use in proje
		for (int i = 1; i < 10; i++) {
			String romid = "";
			for (int j = 1; j < 16; j++) {
				if (j < 10) {
					romid = "cr" + String.valueOf(i) + "0" + String.valueOf(j);

				} else {
					romid = "cr" + String.valueOf(i) + String.valueOf(j);
				}
				System.out.println(romid);

			}

		}
	}

	private void createPieChartList(int r, int n, int o) {
		ObservableList<PieChart.Data> piechartList = FXCollections.observableArrayList();
		piechartList.add(new PieChart.Data("Not Ready Rooms", n));
		piechartList.add(new PieChart.Data("Occupied Rooms", o));
		piechartList.add(new PieChart.Data("Ready Rooms", r));

		pie.setData(piechartList);

		pie.setTitle("Hotel Situations");

	}

	private void creatPie123(int one, int tow, int three, int four, int six, PieChart p, String title) {
		ObservableList<PieChart.Data> piechartList = FXCollections.observableArrayList();
		piechartList.add(new PieChart.Data("One bed rooms", one));
		piechartList.add(new PieChart.Data("Tow beds rooms", tow));
		piechartList.add(new PieChart.Data("Three beds rooms", three));
		piechartList.add(new PieChart.Data("Four beds rooms", four));
		piechartList.add(new PieChart.Data("Six beds rooms", six));
		p.setData(piechartList);
		p.setTitle(title);
	}

	@FXML
	void initAllRoomsColors() {
		roomIdLabel.setText(String.valueOf(selectedRoomNr));
		roomDetails.setVisible(false);

		ArrayList<Circle> listOfCircle = new ArrayList<Circle>(Arrays.asList(cr101, cr102, cr103, cr104, cr105, cr106,
				cr107, cr108, cr109, cr110, cr111, cr112, cr113, cr114, cr115, cr201, cr202, cr203, cr204, cr205, cr206,
				cr207, cr208, cr209, cr210, cr211, cr212, cr213, cr214, cr215, cr301, cr302, cr303, cr304, cr305, cr306,
				cr307, cr308, cr309, cr310, cr311, cr312, cr313, cr314, cr315, cr401, cr402, cr403, cr404, cr405, cr406,
				cr407, cr408, cr409, cr410, cr411, cr412, cr413, cr414, cr415, cr501, cr502, cr503, cr504, cr505, cr506,
				cr507, cr508, cr509, cr510, cr511, cr512, cr513, cr514, cr515, cr601, cr602, cr603, cr604, cr605, cr606,
				cr607, cr608, cr609, cr610, cr611, cr612, cr613, cr614, cr615, cr701, cr702, cr703, cr704, cr705, cr706,
				cr707, cr708, cr709, cr710, cr711, cr712, cr713, cr714, cr715, cr801, cr802, cr803, cr804, cr805, cr806,
				cr807, cr808, cr809, cr810, cr811, cr812, cr813, cr814, cr815, cr901, cr902, cr903, cr904, cr905, cr906,
				cr907, cr908, cr909, cr910, cr911, cr912, cr913, cr914, cr915));

		for (Circle circle : listOfCircle) {
			String st = circle.getId().toString();
			Room myRoom = Mymethode.getRoomByRoomId(st, roomsList);
			circle.setFill(Mymethode.getCircleColorBySituatuions(myRoom));

		}
		totalReadyRooms = 0;
		totalNotReadyRooms = 0;
		occupiedRooms = 0;

		for (int i = 0; i < roomsList.size(); i++) {
			switch (roomsList.get(i).getSituation()) {
			case 0: {
				totalNotReadyRooms += 1;
				if (roomsList.get(i).getBeds() == 1) {
					t2NOne.setText(String.valueOf(Integer.parseInt(t2NOne.getText()) + 1));

					if (roomsList.get(i).getGetLandery() == 0)
						label18.setText(String.valueOf(Integer.parseInt(label18.getText()) + 1));

					if (roomsList.get(i).getSetLandery() == 0)
						label19.setText(String.valueOf(Integer.parseInt(label19.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label110.setText(String.valueOf(Integer.parseInt(label110.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label111.setText(String.valueOf(Integer.parseInt(label111.getText()) + 1));

				}

				if (roomsList.get(i).getBeds() == 2) {
					t2NTow.setText(String.valueOf(Integer.parseInt(t2NTow.getText()) + 1));
					if (roomsList.get(i).getGetLandery() == 0)
						label28.setText(String.valueOf(Integer.parseInt(label28.getText()) + 1));
					if (roomsList.get(i).getSetLandery() == 0)
						label29.setText(String.valueOf(Integer.parseInt(label29.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label210.setText(String.valueOf(Integer.parseInt(label210.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label211.setText(String.valueOf(Integer.parseInt(label211.getText()) + 1));
				}

				if (roomsList.get(i).getBeds() == 3) {
					t2NThree.setText(String.valueOf(Integer.parseInt(t2NThree.getText()) + 1));
					if (roomsList.get(i).getGetLandery() == 0)
						label38.setText(String.valueOf(Integer.parseInt(label38.getText()) + 1));
					if (roomsList.get(i).getSetLandery() == 0)
						label39.setText(String.valueOf(Integer.parseInt(label39.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label310.setText(String.valueOf(Integer.parseInt(label310.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label311.setText(String.valueOf(Integer.parseInt(label311.getText()) + 1));
				}

				if (roomsList.get(i).getBeds() == 4) {
					t2NFour.setText(String.valueOf(Integer.parseInt(t2NFour.getText()) + 1));
					if (roomsList.get(i).getGetLandery() == 0)
						label48.setText(String.valueOf(Integer.parseInt(label48.getText()) + 1));
					if (roomsList.get(i).getSetLandery() == 0)
						label49.setText(String.valueOf(Integer.parseInt(label49.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label410.setText(String.valueOf(Integer.parseInt(label410.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label411.setText(String.valueOf(Integer.parseInt(label411.getText()) + 1));
				}

				if (roomsList.get(i).getBeds() == 6) {
					t2NSix.setText(String.valueOf(Integer.parseInt(t2NSix.getText()) + 1));
					if (roomsList.get(i).getGetLandery() == 0)
						label58.setText(String.valueOf(Integer.parseInt(label58.getText()) + 1));
					if (roomsList.get(i).getSetLandery() == 0)
						label59.setText(String.valueOf(Integer.parseInt(label59.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label510.setText(String.valueOf(Integer.parseInt(label510.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label511.setText(String.valueOf(Integer.parseInt(label511.getText()) + 1));
				}

				break;
			}
			case 5: {
				occupiedRooms += 1;
				if (roomsList.get(i).getBeds() == 1) {
					t2OOne.setText(String.valueOf(Integer.parseInt(t2OOne.getText()) + 1));
					if (roomsList.get(i).getGetLandery() == 0)
						label13.setText(String.valueOf(Integer.parseInt(label13.getText()) + 1));
					if (roomsList.get(i).getSetLandery() == 0)
						label14.setText(String.valueOf(Integer.parseInt(label14.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label15.setText(String.valueOf(Integer.parseInt(label15.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label16.setText(String.valueOf(Integer.parseInt(label16.getText()) + 1));
				}

				if (roomsList.get(i).getBeds() == 2) {
					if (roomsList.get(i).getGetLandery() == 0)
						label23.setText(String.valueOf(Integer.parseInt(label23.getText()) + 1));
					if (roomsList.get(i).getSetLandery() == 0)
						label24.setText(String.valueOf(Integer.parseInt(label24.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label25.setText(String.valueOf(Integer.parseInt(label25.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label26.setText(String.valueOf(Integer.parseInt(label26.getText()) + 1));
					t2OTow.setText(String.valueOf(Integer.parseInt(t2OTow.getText()) + 1));
				}

				if (roomsList.get(i).getBeds() == 3) {
					if (roomsList.get(i).getGetLandery() == 0)
						label33.setText(String.valueOf(Integer.parseInt(label33.getText()) + 1));
					if (roomsList.get(i).getSetLandery() == 0)
						label34.setText(String.valueOf(Integer.parseInt(label34.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label35.setText(String.valueOf(Integer.parseInt(label35.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label36.setText(String.valueOf(Integer.parseInt(label36.getText()) + 1));
					t2OThree.setText(String.valueOf(Integer.parseInt(t2OThree.getText()) + 1));
				}

				if (roomsList.get(i).getBeds() == 4) {
					t2OFour.setText(String.valueOf(Integer.parseInt(t2OFour.getText()) + 1));
					if (roomsList.get(i).getSetLandery() == 0)
						label44.setText(String.valueOf(Integer.parseInt(label44.getText()) + 1));
					if (roomsList.get(i).getGetLandery() == 0)
						label43.setText(String.valueOf(Integer.parseInt(label43.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label45.setText(String.valueOf(Integer.parseInt(label45.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label46.setText(String.valueOf(Integer.parseInt(label46.getText()) + 1));
				}

				if (roomsList.get(i).getBeds() == 6) {
					if (roomsList.get(i).getGetLandery() == 0)
						label53.setText(String.valueOf(Integer.parseInt(label53.getText()) + 1));
					if (roomsList.get(i).getSetLandery() == 0)
						label54.setText(String.valueOf(Integer.parseInt(label54.getText()) + 1));
					if (roomsList.get(i).getCleanRoom() == 0)
						label65.setText(String.valueOf(Integer.parseInt(label55.getText()) + 1));
					if (roomsList.get(i).getNeedTechnick() == 0)
						label56.setText(String.valueOf(Integer.parseInt(label56.getText()) + 1));
					t2OSix.setText(String.valueOf(Integer.parseInt(t2OSix.getText()) + 1));
				}

				break;
			}
			case 10: {
				totalReadyRooms += 1;

				if (roomsList.get(i).getBeds() == 1)
					t2ROne.setText(String.valueOf(Integer.parseInt(t2ROne.getText()) + 1));

				if (roomsList.get(i).getBeds() == 2)
					t2RTow.setText(String.valueOf(Integer.parseInt(t2RTow.getText()) + 1));

				if (roomsList.get(i).getBeds() == 3)
					t2RThree.setText(String.valueOf(Integer.parseInt(t2RThree.getText()) + 1));

				if (roomsList.get(i).getBeds() == 4)
					t2RFour.setText(String.valueOf(Integer.parseInt(t2RFour.getText()) + 1));

				if (roomsList.get(i).getBeds() == 6)
					t2RSix.setText(String.valueOf(Integer.parseInt(t2RSix.getText()) + 1));

				break;
			} // case 10
			} // switch

		} // for

		textNotReadyRooms.setText(String.valueOf(totalNotReadyRooms));
		textOccupiedRooms.setText(String.valueOf(occupiedRooms));
		textReadyRooms.setText(String.valueOf(totalReadyRooms));
		int p = ((totalReadyRooms * 100) / 135);
		perReady.setText(p + "%");
		p = ((totalNotReadyRooms * 100) / 135);
		perNotReady.setText(p + "%");
		p = ((occupiedRooms * 100) / 135);
		perOccupied.setText(p + "%");
		createPieChartList(totalReadyRooms, totalNotReadyRooms, occupiedRooms);
		creatPie123(Integer.parseInt(t2ROne.getText()), Integer.parseInt(t2RTow.getText()),
				Integer.parseInt(t2RThree.getText()), Integer.parseInt(t2RFour.getText()),
				Integer.parseInt(t2RSix.getText()), pie1, "Ready Rooms");
		creatPie123(Integer.parseInt(t2OOne.getText()), Integer.parseInt(t2OTow.getText()),
				Integer.parseInt(t2OThree.getText()), Integer.parseInt(t2OFour.getText()),
				Integer.parseInt(t2OSix.getText()), pie2, "Occupied Rooms");
		creatPie123(Integer.parseInt(t2NOne.getText()), Integer.parseInt(t2NTow.getText()),
				Integer.parseInt(t2NThree.getText()), Integer.parseInt(t2NFour.getText()),
				Integer.parseInt(t2NSix.getText()), pie3, "Not Ready Rooms");

		/////////////////////////

		t2RTotal.setText(String.valueOf(totalReadyRooms));
		t2OTolals.setText(String.valueOf(occupiedRooms));
		t2NTotals.setText(String.valueOf(totalNotReadyRooms));

		int s = Integer.parseInt(label13.getText()) + Integer.parseInt(label23.getText())
				+ Integer.parseInt(label33.getText()) + Integer.parseInt(label43.getText())
				+ Integer.parseInt(label53.getText());
		label63.setText(s + "");
		s = Integer.parseInt(label14.getText()) + Integer.parseInt(label24.getText())
				+ Integer.parseInt(label34.getText()) + Integer.parseInt(label44.getText())
				+ Integer.parseInt(label54.getText());
		label64.setText(s + "");
		s = Integer.parseInt(label15.getText()) + Integer.parseInt(label25.getText())
				+ Integer.parseInt(label35.getText()) + Integer.parseInt(label45.getText())
				+ Integer.parseInt(label55.getText());
		label65.setText(s + "");
		s = Integer.parseInt(label16.getText()) + Integer.parseInt(label26.getText())
				+ Integer.parseInt(label36.getText()) + Integer.parseInt(label46.getText())
				+ Integer.parseInt(label56.getText());
		label66.setText(s + "");

///////////////////////////

		s = Integer.parseInt(label18.getText()) + Integer.parseInt(label28.getText())
				+ Integer.parseInt(label38.getText()) + Integer.parseInt(label48.getText())
				+ Integer.parseInt(label58.getText());

		label68.setText(s + "");

		s = Integer.parseInt(label19.getText()) + Integer.parseInt(label29.getText())
				+ Integer.parseInt(label39.getText()) + Integer.parseInt(label49.getText())
				+ Integer.parseInt(label59.getText());
		label69.setText(s + "");

		s = Integer.parseInt(label110.getText()) + Integer.parseInt(label210.getText())
				+ Integer.parseInt(label310.getText()) + Integer.parseInt(label410.getText())
				+ Integer.parseInt(label510.getText());
		label610.setText(s + "");
		s = Integer.parseInt(label111.getText()) + Integer.parseInt(label211.getText())
				+ Integer.parseInt(label311.getText()) + Integer.parseInt(label411.getText())
				+ Integer.parseInt(label511.getText());
		label611.setText(s + "");

	}

	@FXML
	void initAllRoomsEvents() {
		roomIdLabel.setText(String.valueOf(selectedRoomNr));
		roomDetails.setVisible(false);

		ArrayList<Circle> listOfCircle = new ArrayList<Circle>(Arrays.asList(cr101, cr102, cr103, cr104, cr105, cr106,
				cr107, cr108, cr109, cr110, cr111, cr112, cr113, cr114, cr115, cr201, cr202, cr203, cr204, cr205, cr206,
				cr207, cr208, cr209, cr210, cr211, cr212, cr213, cr214, cr215, cr301, cr302, cr303, cr304, cr305, cr306,
				cr307, cr308, cr309, cr310, cr311, cr312, cr313, cr314, cr315, cr401, cr402, cr403, cr404, cr405, cr406,
				cr407, cr408, cr409, cr410, cr411, cr412, cr413, cr414, cr415, cr501, cr502, cr503, cr504, cr505, cr506,
				cr507, cr508, cr509, cr510, cr511, cr512, cr513, cr514, cr515, cr601, cr602, cr603, cr604, cr605, cr606,
				cr607, cr608, cr609, cr610, cr611, cr612, cr613, cr614, cr615, cr701, cr702, cr703, cr704, cr705, cr706,
				cr707, cr708, cr709, cr710, cr711, cr712, cr713, cr714, cr715, cr801, cr802, cr803, cr804, cr805, cr806,
				cr807, cr808, cr809, cr810, cr811, cr812, cr813, cr814, cr815, cr901, cr902, cr903, cr904, cr905, cr906,
				cr907, cr908, cr909, cr910, cr911, cr912, cr913, cr914, cr915));

		for (Circle circle : listOfCircle) {

			circle.setOnMouseMoved(e -> {
				if (circle.getFill() == Color.INDIANRED)
					circle.setFill(Color.RED);
				else if (circle.getFill() == Color.ROYALBLUE)
					circle.setFill(Color.BLUE);
				else if (circle.getFill() == Color.DARKOLIVEGREEN)
					circle.setFill(Color.GREEN);
			});

			circle.setOnMouseExited(e -> {
				if (circle.getFill() == Color.RED)
					circle.setFill(Color.INDIANRED);
				else if (circle.getFill() == Color.BLUE)
					circle.setFill(Color.ROYALBLUE);
				else if (circle.getFill() == Color.GREEN)
					circle.setFill(Color.DARKOLIVEGREEN);
			});
		}
	}

	@FXML
	void initialize() {

		System.out.println("init...");
		dao = new RoomsSQLiteDAO();
		roomsList = dao.getAll();
		initAllRoomsColors();
		initAllRoomsEvents();

	}

}
