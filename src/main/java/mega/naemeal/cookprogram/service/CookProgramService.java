package mega.naemeal.cookprogram.service;


import java.util.List;

public interface CookProgramService {

    CookProgramResponseDto createPost(String userId, CookProgramRequestDto requestDto, String imgPath);
    CookProgramResponseDto updatePost(CookProgramRequestDto requestDto, Long postId,  String userId, String imgPath);
    String getPostImage(String userId, Long postId);
    void deletePost(Long postId, String userId);
    List<AllCookProgramResponseDto> getAllPost();
    CookProgramResponseDto getPost(Long postId);


}