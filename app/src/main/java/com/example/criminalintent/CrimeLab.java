package com.example.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    //private 키워드로 외부 접근 차단.
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    //외부 접근이 차단된 CrimeLab의 인스턴스를 생성하기 위한 get함수.
    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    //생성자
    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        for(int i =0; i< 100; i++){
            Crime crime = new Crime();
            crime.setTitle("범죄 #" + i);
            crime.setSolved(i%2 == 0); // 짝수번째 요소 true값 임의 설정.
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for(Crime crime : mCrimes){
            if(crime.getID().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
