package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    private Song findSong(String songName) {
        for(Song checkedSong: this.songs) {

            if(checkedSong.getTitle().equals(songName)) {
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addSong(String songName, double duration) {

        if (findSong(songName) == null) {
            this.songs.add(new Song(songName,duration));
            return true;
        } else {
            System.out.println("Song already exists with this name");
            return false;
        }

    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber -1;
        if((index >= 0) && (index <= this.songs.size()-1)) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String songName, LinkedList<Song> playlist){
        Song song = findSong(songName);

        if(song != null) {
            playlist.add(song);
            return true;
        } else {
            System.out.println("The song " + songName + " is not in this album");
            return false;
        }
    }


    }
