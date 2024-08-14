package com.ohgiraffers.pikka_backserver.auth.cafeApi.controller;

import com.ohgiraffers.pikka_backserver.auth.cafeApi.model.JobCafeDTO;
import com.ohgiraffers.pikka_backserver.auth.cafeApi.service.JobCafeService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


@RestController
@RequestMapping("/api")
public class CafeApiController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private JobCafeService jobCafeService;

    @GetMapping("/jobcafe")
    public String getJobCafe() throws IOException {

        // API 요청을 위한 URL을 빌드합니다.
        StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");

        // API Key, 요청 파일 타입, 서비스명, 시작 및 종료 위치 설정
        urlBuilder.append("/" + URLEncoder.encode(apiKey, "UTF-8")); // 인증키
        urlBuilder.append("/" + URLEncoder.encode("xml", "UTF-8")); /* 요청파일타입 (xml, xmlf, xls, json) */
        urlBuilder.append("/" + URLEncoder.encode("jobCafeOpenInfo", "UTF-8")); /* 서비스명 (대소문자 구분 필수) */
        urlBuilder.append("/" + URLEncoder.encode("1", "UTF-8")); /* 요청 시작 위치 */
        urlBuilder.append("/" + URLEncoder.encode("30", "UTF-8")); /* 요청 종료 위치 */

        // URL 객체 생성 및 HTTP 연결 설정
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET"); // GET 메소드 설정

        // 응답 유형 설정
        conn.setRequestProperty("Content-type", "application/xml");

        // 응답 코드 확인 및 입력 스트림 설정
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        // 응답 데이터 읽기
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        // 원본 XML 데이터를 JSON으로 변환
        String rawData = sb.toString();
        String jsonData = convertXmlToJson(rawData);

        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray jsonArray = jsonObject.getJSONObject("jobCafeOpenInfo").getJSONArray("row");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jobcafeJson = jsonArray.getJSONObject(i);
            JobCafeDTO jobCafeDTO = new JobCafeDTO();
            jobCafeDTO.setCafeName(jobcafeJson.getString("CAFE_NM"));
            jobCafeDTO.setSimpleIntro(jobcafeJson.getString("SMPL_INTRO"));
            jobCafeDTO.setCafeType(jobcafeJson.getString("CAFE_TYPE_NM"));
            jobCafeDTO.setUseDate(jobcafeJson.getString("USE_DT"));
            jobCafeDTO.setBaseAddress(jobcafeJson.getString("BASS_ADRES_CN"));
            jobCafeDTO.setRoadAddress(jobcafeJson.getString("ROAD_ADRES2_CN"));
            jobCafeDTO.setSpaceInfo(jobcafeJson.getString("SPACE_INFRO"));

            jobCafeDTO.setFacilityInfo1(jobcafeJson.getString("FACLT_INFO1"));
            jobCafeDTO.setFacilityInfo2(jobcafeJson.getString("FACLT_INFO2"));
            jobCafeDTO.setFacilityInfo3(jobcafeJson.getString("FACLT_INFO3"));
            jobCafeDTO.setFacilityInfo4(jobcafeJson.getString("FACLT_INFO4"));
            jobCafeDTO.setFacilityInfo5(jobcafeJson.getString("FACLT_INFO5"));
            jobCafeDTO.setFacilityInfo6(jobcafeJson.getString("FACLT_INFO6"));
            jobCafeDTO.setFacilityInfo7(jobcafeJson.getString("FACLT_INFO7"));
            jobCafeDTO.setFacilityInfo8(jobcafeJson.getString("FACLT_INFO8"));
            jobCafeDTO.setFacilityInfo9(jobcafeJson.getString("FACLT_INFO9"));

            jobCafeDTO.setHoliday(jobcafeJson.getString("HOLI_DD"));

            jobCafeDTO.setReservationSuggestion1(jobcafeJson.getString("RSRV_SGGST1"));
            jobCafeDTO.setReservationSuggestion2(jobcafeJson.getString("RSRV_SGGST2"));
            jobCafeDTO.setReservationSuggestion3(jobcafeJson.getString("RSRV_SGGST3"));
            jobCafeDTO.setReservationSuggestion4(jobcafeJson.getString("RSRV_SGGST4"));
            jobCafeDTO.setReservationSuggestion5(jobcafeJson.getString("RSRV_SGGST5"));
            jobCafeDTO.setReservationSuggestion6(jobcafeJson.getString("RSRV_SGGST6"));
            jobCafeDTO.setReservationSuggestion7(jobcafeJson.getString("RSRV_SGGST7"));
            jobCafeDTO.setReservationSuggestion8(jobcafeJson.getString("RSRV_SGGST8"));
            jobCafeDTO.setReservationSuggestion9(jobcafeJson.getString("RSRV_SGGST9"));

            jobCafeDTO.setFileName(jobcafeJson.getString("FILE_NM"));

            // Service를 통해 DTO를 저장
            jobCafeService.saveJobCafe(jobCafeDTO);

        }


        return jsonData;


    }


    private String convertXmlToJson(String xmlData) {
        // XML 데이터를 JSON 객체로 변환
        JSONObject json = XML.toJSONObject(xmlData);
        // JSON 데이터를 예쁘게 포맷팅 (4개의 공백으로 들여쓰기)
        return json.toString(4);
    }


}
