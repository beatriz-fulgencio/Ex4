import Microsoft.Azure.CognitiveServices.Vision.Face;
import Microsoft.Azure.CognitiveServices.Vision.Face.Models;

import java.util.ArrayList;
import java.util.Scanner;

import System;
import System.Collections.Generic;
import System.Threading.Tasks;

class Program {

    public static IFaceClient Authenticate(String endpoint, String key) {
        return new FaceClient(new ApiKeyServiceClientCredentials(key));
    }

    public static Task DetectFaceExtract(IFaceClient client, String url, String recognitionModel) {
            System.Out.println("======== DETEC��O DE ROSTOS ========");
            System.Out.println();
            //  No exemplo do Tutorial da Microsoft eles realizavam uma an�lise de um conjunto de fotos,
            //  na minha implementa��o quero que a API analise uma foto por vez
            ArrayList<DetectedFace> detectedFaces;
            //  Declara��o de uma lista para separar as faces encontradas na foto
            detectedFaces = client.Face.DetectWithUrlAsync("{url}", returnFaceAttributes: new ArrayList<FaceAttributeType>[] {
                        FaceAttributeType.Age,
                        FaceAttributeType.Emotion,
                        FaceAttributeType.FacialHair,
                        FaceAttributeType.Hair,
                        FaceAttributeType.Gender,
                        FaceAttributeType.Glasses,
                        FaceAttributeType.Makeup,
                        FaceAttributeType.Smile}, recognitionModel: recognitionModel);
            //  e o modelo de reconhecimento
            System.Out.println(" {detectedFaces.Count} rostos detectados na imagem!");
            //  O .count da nossa lista � um contador de numeros de faces detectadas na foto
            System.Out.println();
            //  Printa atributos de cada Face
            for (var face : detectedFaces) {
                System.Out.println(" ATRIBUTOS DO ROSTO");
                System.Out.println(" Ret�ngulo/Posi��o (Left/Top/Width/Height) : {face.FaceRectangle.Left} {face.FaceRectangle.Top} {face" +
                    ".FaceRectangle.Width} {face.FaceRectangle.Height}");
                System.Out.println(" Idade : {face.FaceAttributes.Age}");
                System.Out.println(" G�nero : {face.FaceAttributes.Gender}");
                System.Out.println(" �culos: {face.FaceAttributes.Glasses}");
                System.Out.println(" Maquiagem : {String.Format(", {, 0);
            }
            
            ", (face.FaceAttributes.Makeup.EyeMakeup || face.FaceAttributes.Makeup.LipMakeup) ? ";
            Yes;
            " : ";
            No;
            ")}";
            System.Out.println(" Cabelo facial/barba/bigode : {String.Format(", {, 0);
        
        
        Hair hair = face.FaceAttributes.Hair;
        
        String color = null;
    

UnknownHairColorType return Color = HairColorType.Unknown;
double maxConfidence = 0;
for (HairColor hairColor : hair.HairColor) {
    if ((hairColor.Confidence <= maxConfidence)) {
        break;
    }
    
    maxConfidence = hairColor.Confidence;
    return Color = hairColor.Color;
    color = return Color.ToString();
}

System.Out.println(" Cor do cabelo : {color}");
System.Out.println();
System.Out.println(" EMO��ES DO ROSTO");
System.Out.println((" Raiva : " + face.FaceAttributes.Emotion.Anger));
System.Out.println((" Desprezo : " + face.FaceAttributes.Emotion.Contempt));
System.Out.println((" Nojo : " + face.FaceAttributes.Emotion.Disgust));
System.Out.println((" Medo : " + face.FaceAttributes.Emotion.Fear));
System.Out.println((" Felicidade : " + face.FaceAttributes.Emotion.Happiness));
System.Out.println((" Neutro : " + face.FaceAttributes.Emotion.Neutral));
System.Out.println((" Tristeza : " + face.FaceAttributes.Emotion.Sadness));
System.Out.println((" Surpresa : " + face.FaceAttributes.Emotion.Surprise));
System.Out.println();
System.Out.println();
System.Out.println();
}

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String RECOGNITION_MODEL2 = RecognitionModel.Recognition02;
        final String RECOGNITION_MODEL1 = RecognitionModel.Recognition01;
        String url_do_video;
        // INTERFACE PARA AUTENTICAR O SEU RECURSO DE RECONHECIMENTO FACIAL DO AZURE
        // IFaceClient client = Authenticate(<ENDPOINT>, <SUBSCRIPTION_KEY>);
        IFaceClient client = Authenticate("https://detectandofaces.cognitiveservices.azure.com/",
                "58082034cf5b44a999e713a992f2b5fb");
        url_do_video = "https://imagens.canaltech.com.br/235861.470219-StyleGAN.jpg";
        DetectFaceExtract(client, url_do_video, RECOGNITION_MODEL2).Wait();
        sc.nextLine();
        url_do_video = "https://www.odebate.com.br/wp-content/uploads/2019/01/raiva.jpg";
        DetectFaceExtract(client, url_do_video, RECOGNITION_MODEL2).Wait();
        sc.nextLine();
        url_do_video = "https://media.istockphoto.com/photos/surprised-young-man-portrait-picture-id521680719";
        DetectFaceExtract(client, url_do_video, RECOGNITION_MODEL2).Wait();
    }
}