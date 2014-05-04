package be.brickbit.main;

import be.brickbit.parser.Parser;
import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.Recognizer;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Runner {
    public static void main(String[] args) throws IOException, LineUnavailableException, InterruptedException {
        Microphone microphone = new Microphone(AudioFileFormat.Type.WAVE);
        Recognizer recognizer = new Recognizer();
        recognizer.setLanguage(Recognizer.Languages.ENGLISH_US);
        Parser parser = new Parser();

        boolean isStopCommandGiven = false;

        while (!isStopCommandGiven) {
            getVoiceCommand(microphone);
            isStopCommandGiven = parseCommand(parser, parseSpeechToText(recognizer));
            System.out.println("Command Parsed.");
        }
    }

    private static boolean parseCommand(Parser someParser, String someText) {
        System.out.println("You said: " + someText);
        if(someText != null){
            if(someText.contains("shut down")){
                return true;
            }else{
                someParser.parseCommand(someText);
                return false;
            }
        }
        return false;
    }

    private static String parseSpeechToText(Recognizer someRecognizer) throws IOException {
        return someRecognizer.getRecognizedDataForWave("temp.wav").getResponse();
    }

    private static void getVoiceCommand(Microphone someMicrophone) throws LineUnavailableException,
            InterruptedException {
        System.out.println("Start speaking");
        someMicrophone.captureAudioToFile("temp.wav");
        sleep(5000);
        someMicrophone.close();
    }
}
