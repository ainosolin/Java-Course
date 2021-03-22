package com.example.viikko9;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ReadXML {

    private static ArrayList showList;
    private static ArrayList theatreArrayList;
    private static ArrayList imgList;

    static ArrayList readTheatreAreaXML() {

        try {
            theatreArrayList = new ArrayList<Theatre>();
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nlist = doc.getDocumentElement().getElementsByTagName("TheatreArea");

            for (int i = 0; i < nlist.getLength(); i++) {
                Node node = nlist.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String tId = element.getElementsByTagName("ID").item(0).getTextContent();
                    String tName = element.getElementsByTagName("Name").item(0).getTextContent();
                    theatreArrayList.add(new Theatre(tName, tId));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            System.out.println("###################");
            return theatreArrayList;
        }

    }

static ArrayList readImgXML(String tId, String pvm) {
    try {
        imgList = new ArrayList<String>();

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        String urlString = "https://www.finnkino.fi/xml/Schedule/?area=" + tId + "&dt=" + pvm;

        System.out.println(urlString);

        Document doc = builder.parse(urlString);
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nlist2 = doc.getDocumentElement().getElementsByTagName("Images");
        for (int i = 1; i < nlist2.getLength(); i++) {
            Node node2 = nlist2.item(i);
            if (node2.getNodeType() == Node.ELEMENT_NODE) {
                Element element2 = (Element) node2;
                String showImg = element2.getElementsByTagName("EventSmallImagePortrait").item(0).getTextContent();
                imgList.add(showImg);
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } finally {
        System.out.println("###################");
        return imgList;
    }
}

    static ArrayList readScheduleXML(String tId, String pvm) {
        try {
            showList = new ArrayList<Show>();

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/Schedule/?area=" + tId + "&dt=" + pvm;

            System.out.println(urlString);

            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nlist = doc.getDocumentElement().getElementsByTagName("Show");

            for (int i = 1; i < nlist.getLength(); i++) {
                Node node = nlist.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Get elements and store in showList as Shows

                    String showId = element.getElementsByTagName("ID").item(0).getTextContent();
                    String showTitle = element.getElementsByTagName("Title").item(0).getTextContent();
                    String showStart = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                    showStart = showStart.substring(11, 16);
                    String showEnd = element.getElementsByTagName("dttmShowEnd").item(0).getTextContent();
                    showEnd = showEnd.substring(11, 16);
                    String showPubYear = element.getElementsByTagName("ProductionYear").item(0).getTextContent();
                    String eventUrl = element.getElementsByTagName("EventURL").item(0).getTextContent();

                    showList.add(new Show(showId, showTitle, showStart, showEnd, showPubYear, eventUrl));
                }
            }
            } catch(IOException e){
                e.printStackTrace();
            } catch(SAXException e){
                e.printStackTrace();
            } catch(ParserConfigurationException e){
                e.printStackTrace();
            } finally{
                System.out.println("###################");
                return showList;
            }
        }
    }

